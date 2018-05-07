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
 * The [CardCrypto] interface defines a list of methods that provide a signature generation and signature
 * verification methods.
 */
interface CardCrypto {

    /**
     * Exports the `publicKey` into material representation.
     *
     * @param publicKey The public key.
     *
     * @return Public key in material representation of `byte[]`.
     *
     * @throws CryptoException if problems occurred while exporting key
     */
    @Throws(CryptoException::class)
    fun exportPublicKey(publicKey: PublicKey): ByteArray

    /**
     * Generates the fingerprint(512-bit hash) for the specified `data`.
     *
     * @param data The input data for which to compute the fingerprint.
     *
     * @return The fingerprint for specified data.
     *
     * @throws CryptoException if problems occurred while generating hash
     */
    @Throws(CryptoException::class)
    fun generateSHA512(data: ByteArray): ByteArray

    /**
     * Generates the digital signature for the specified `data` using the specified [PrivateKey]
     *
     * @param data The input data for which to compute the signature.
     * @param privateKey The private key.
     *
     * @return The digital signature for the specified data.
     *
     * @throws CryptoException if problems occurred while generating signature.
     */
    @Throws(CryptoException::class)
    fun generateSignature(data: ByteArray, privateKey: PrivateKey): ByteArray

    /**
     * Imports the public key from its material representation.
     *
     * @param data The public key material representation bytes.
     *
     * @return The instance of [PublicKey] imported.
     *
     * @throws CryptoException if problems occurred while importing key
     */
    @Throws(CryptoException::class)
    fun importPublicKey(data: ByteArray): PublicKey

    /**
     * Verifies that a digital signature is valid by checking the `signature`, with provided `publicKey` and
     * `data`.
     *
     * @param signature The digital signature for the `data`.
     * @param data The input data for which the `signature` has been generated.
     * @param publicKey The [PublicKey].
     *
     * @return `true` if signature is valid, `false` otherwise.
     *
     * @throws CryptoException if problems occurred while verifying signature.
     */
    @Throws(CryptoException::class)
    fun verifySignature(signature: ByteArray, data: ByteArray, publicKey: PublicKey): Boolean
}
