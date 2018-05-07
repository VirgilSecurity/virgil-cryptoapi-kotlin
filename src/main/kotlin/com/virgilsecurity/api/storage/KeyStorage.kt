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
package com.virgilsecurity.api.storage

/**
 * Created by:
 * Danylo Oliinyk
 * on
 * 3/19/18
 * at Virgil Security
 */

/**
 * This interface describes a storage facility for cryptographic keys.
 */
interface KeyStorage {

    /**
     * Stores the private key (that has already been protected) to the given alias.
     *
     * @param keyEntry The key entry.
     */
    fun store(keyEntry: KeyEntry)

    /**
     * Loads the private key associated with the given alias.
     *
     * @param name The key name.
     *
     * @return The requested private key, or null if the given alias does not exist
     * or does not identify a key-related entry.
     */
    fun load(name: String): KeyEntry

    /**
     * Checks if the private key exists in this storage by given alias.
     *
     * @param name The key name.
     *
     * @return `true` if the private key exists, `false` otherwise.
     */
    fun exists(name: String): Boolean

    /**
     * Deletes the private key from key store by given name.
     *
     * @param name The key name.
     */
    fun delete(name: String)

    /**
     * Get names of keys stored in key store.
     *
     * @return the set of key names.
     */
    fun names(): Set<String>

}
