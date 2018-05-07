/*
 * Copyright (c) 2015-2018, Virgil Security, Inc.
 *
 * Lead Maintainer: Virgil Security Inc. <support@virgilsecurity.com>
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *     (1) Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *
 *     (2) Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *     (3) Neither the name of virgil nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.virgilsecurity.api.crypto

import com.virgilsecurity.api.exception.CryptoException

/**
 * Created by:
 * Danylo Oliinyk
 * on
 * 3/16/18
 * at Virgil Security
 */

/**
 * The [AccessTokenSigner] interface represents an opaque reference to access token signing management objects
 * handled by the agent.
 */
interface AccessTokenSigner {

    /**
     * The algorithm
     */
    val algorithm: String

    /**
     * Generate token signature with provided [PrivateKey].
     *
     * @param token the token
     * @param privateKey the private key
     *
     * @return the byte [ ]
     *
     * @throws CryptoException
     * if signature generation issue occurred
     */
    @Throws(CryptoException::class)
    fun generateTokenSignature(token: ByteArray, privateKey: PrivateKey): ByteArray

    /**
     * Verifies the specified signature using original data and signer's [PublicKey].
     *
     * @param signature signature bytes for verification
     * @param data original data bytes for verification
     * @param publicKey signer's public key for verification
     *
     * @return `true` if signature is valid, `false` otherwise.
     *
     * @throws CryptoException
     * if signature verification issue occurred
     */
    @Throws(CryptoException::class)
    fun verifyTokenSignature(signature: ByteArray, data: ByteArray, publicKey: PublicKey): Boolean
}
