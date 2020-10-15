/*
 * Copyright 2020-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.lettuce.core.api.coroutines

import io.lettuce.core.*
import kotlinx.coroutines.flow.Flow

/**
 * Coroutine executed commands for Strings.
 *
 * @param <K> Key type.
 * @param <V> Value type.
 * @author Mikhael Sokolov
 * @since 6.0
 * @generated by io.lettuce.apigenerator.CreateKotlinCoroutinesApi
 */
@ExperimentalLettuceCoroutinesApi
interface RedisStringCoroutinesCommands<K : Any, V : Any> {

    /**
     * Append a value to a key.
     *
     * @param key the key.
     * @param value the value.
     * @return Long integer-reply the length of the string after the append operation.
     */
    suspend fun append(key: K, value: V): Long?

    /**
     * Count set bits in a string.
     *
     * @param key the key.
     * @return Long integer-reply The number of bits set to 1.
     */
    suspend fun bitcount(key: K): Long?

    /**
     * Count set bits in a string.
     *
     * @param key the key.
     * @param start the start.
     * @param end the end.
     * @return Long integer-reply The number of bits set to 1.
     */
    suspend fun bitcount(key: K, start: Long, end: Long): Long?

    /**
     * Execute `BITFIELD` with its subcommands.
     *
     * @param key the key.
     * @param bitFieldArgs the args containing subcommands, must not be `null`.
     * @return Long bulk-reply the results from the bitfield commands.
     */
    suspend fun bitfield(key: K, bitFieldArgs: BitFieldArgs): List<Long>

    /**
     * Find first bit set or clear in a string.
     *
     * @param key the key.
     * @param state the state.
     * @return Long integer-reply The command returns the position of the first bit set to 1 or 0 according to the request.
     *
     *         If we look for set bits (the bit argument is 1) and the string is empty or composed of just zero bytes, -1 is
     *         returned.
     *
     *         If we look for clear bits (the bit argument is 0) and the string only contains bit set to 1, the function returns
     *         the first bit not part of the string on the right. So if the string is tree bytes set to the value 0xff the
     *         command `BITPOS key 0` will return 24, since up to bit 23 all the bits are 1.
     *
     *         Basically the function consider the right of the string as padded with zeros if you look for clear bits and
     *         specify no range or the <em>start</em> argument <strong>only</strong>.
     */
    suspend fun bitpos(key: K, state: Boolean): Long?

    /**
     * Find first bit set or clear in a string.
     *
     * @param key the key.
     * @param state the bit type: long.
     * @param start the start type: long.
     * @return Long integer-reply The command returns the position of the first bit set to 1 or 0 according to the request.
     *
     *         If we look for set bits (the bit argument is 1) and the string is empty or composed of just zero bytes, -1 is
     *         returned.
     *
     *         If we look for clear bits (the bit argument is 0) and the string only contains bit set to 1, the function returns
     *         the first bit not part of the string on the right. So if the string is tree bytes set to the value 0xff the
     *         command `BITPOS key 0` will return 24, since up to bit 23 all the bits are 1.
     *
     *         Basically the function consider the right of the string as padded with zeros if you look for clear bits and
     *         specify no range or the <em>start</em> argument <strong>only</strong>.
     * @since 5.0.1
     */
    suspend fun bitpos(key: K, state: Boolean, start: Long): Long?

    /**
     * Find first bit set or clear in a string.
     *
     * @param key the key.
     * @param state the bit type: long.
     * @param start the start type: long.
     * @param end the end type: long.
     * @return Long integer-reply The command returns the position of the first bit set to 1 or 0 according to the request.
     *
     *         If we look for set bits (the bit argument is 1) and the string is empty or composed of just zero bytes, -1 is
     *         returned.
     *
     *         If we look for clear bits (the bit argument is 0) and the string only contains bit set to 1, the function returns
     *         the first bit not part of the string on the right. So if the string is tree bytes set to the value 0xff the
     *         command `BITPOS key 0` will return 24, since up to bit 23 all the bits are 1.
     *
     *         Basically the function consider the right of the string as padded with zeros if you look for clear bits and
     *         specify no range or the <em>start</em> argument <strong>only</strong>.
     *
     *         However this behavior changes if you are looking for clear bits and specify a range with both
     *         <strong>start</strong> and <strong>end</strong>. If no clear bit is found in the specified range, the function
     *         returns -1 as the user specified a clear range and there are no 0 bits in that range.
     */
    suspend fun bitpos(key: K, state: Boolean, start: Long, end: Long): Long?

    /**
     * Perform bitwise AND between strings.
     *
     * @param destination result key of the operation.
     * @param keys operation input key names.
     * @return Long integer-reply The size of the string stored in the destination key, that is equal to the size of the longest
     *         input string.
     */
    suspend fun bitopAnd(destination: K, vararg keys: K): Long?

    /**
     * Perform bitwise NOT between strings.
     *
     * @param destination result key of the operation.
     * @param source operation input key names.
     * @return Long integer-reply The size of the string stored in the destination key, that is equal to the size of the longest
     *         input string.
     */
    suspend fun bitopNot(destination: K, source: K): Long?

    /**
     * Perform bitwise OR between strings.
     *
     * @param destination result key of the operation.
     * @param keys operation input key names.
     * @return Long integer-reply The size of the string stored in the destination key, that is equal to the size of the longest
     *         input string.
     */
    suspend fun bitopOr(destination: K, vararg keys: K): Long?

    /**
     * Perform bitwise XOR between strings.
     *
     * @param destination result key of the operation.
     * @param keys operation input key names.
     * @return Long integer-reply The size of the string stored in the destination key, that is equal to the size of the longest
     *         input string.
     */
    suspend fun bitopXor(destination: K, vararg keys: K): Long?

    /**
     * Decrement the integer value of a key by one.
     *
     * @param key the key.
     * @return Long integer-reply the value of `key` after the decrement.
     */
    suspend fun decr(key: K): Long?

    /**
     * Decrement the integer value of a key by the given number.
     *
     * @param key the key.
     * @param amount the decrement type: long.
     * @return Long integer-reply the value of `key` after the decrement.
     */
    suspend fun decrby(key: K, amount: Long): Long?

    /**
     * Get the value of a key.
     *
     * @param key the key.
     * @return V bulk-string-reply the value of `key`, or `null` when `key` does not exist.
     */
    suspend fun get(key: K): V?

    /**
     * Returns the bit value at offset in the string value stored at key.
     *
     * @param key the key.
     * @param offset the offset type: long.
     * @return Long integer-reply the bit value stored at <em>offset</em>.
     */
    suspend fun getbit(key: K, offset: Long): Long?

    /**
     * Get a substring of the string stored at a key.
     *
     * @param key the key.
     * @param start the start type: long.
     * @param end the end type: long.
     * @return V bulk-string-reply.
     */
    suspend fun getrange(key: K, start: Long, end: Long): V?

    /**
     * Set the string value of a key and return its old value.
     *
     * @param key the key.
     * @param value the value.
     * @return V bulk-string-reply the old value stored at `key`, or `null` when `key` did not exist.
     */
    suspend fun getset(key: K, value: V): V?

    /**
     * Increment the integer value of a key by one.
     *
     * @param key the key.
     * @return Long integer-reply the value of `key` after the increment.
     */
    suspend fun incr(key: K): Long?

    /**
     * Increment the integer value of a key by the given amount.
     *
     * @param key the key.
     * @param amount the increment type: long.
     * @return Long integer-reply the value of `key` after the increment.
     */
    suspend fun incrby(key: K, amount: Long): Long?

    /**
     * Increment the float value of a key by the given amount.
     *
     * @param key the key.
     * @param amount the increment type: Double.
     * @return Double bulk-string-reply the value of `key` after the increment.
     */
    suspend fun incrbyfloat(key: K, amount: Double): Double?

    /**
     * Get the values of all the given keys.
     *
     * @param keys the key.
     * @return List<V> array-reply list of values at the specified keys.
     */
    fun mget(vararg keys: K): Flow<KeyValue<K, V>>

    /**
     * Set multiple keys to multiple values.
     *
     * @param map the null.
     * @return String simple-string-reply always `OK` since `MSET` can't fail.
     */
    suspend fun mset(map: Map<K, V>): String?

    /**
     * Set multiple keys to multiple values, only if none of the keys exist.
     *
     * @param map the null.
     * @return Boolean integer-reply specifically:
     *
     *         `1` if the all the keys were set. `0` if no key was set (at least one key already existed).
     */
    suspend fun msetnx(map: Map<K, V>): Boolean?

    /**
     * Set the string value of a key.
     *
     * @param key the key.
     * @param value the value.
     * @return String simple-string-reply `OK` if `SET` was executed correctly.
     */
    suspend fun set(key: K, value: V): String?

    /**
     * Set the string value of a key.
     *
     * @param key the key.
     * @param value the value.
     * @param setArgs the setArgs.
     * @return String simple-string-reply `OK` if `SET` was executed correctly.
     */
    suspend fun set(key: K, value: V, setArgs: SetArgs): String?

    /**
     * Set the string value of a key and return its old value.
     *
     * @param key the key
     * @param value the value
     * @return V bulk-string-reply the old value stored at `key`, or `null` when `key` did not exist.
     * @since 6.2
     */
    suspend fun setGet(key: K, value: V): V?

    /**
     * Set the string value of a key and return its old value.
     *
     * @param key the key
     * @param value the value
     * @param setArgs the command arguments
     * @return V bulk-string-reply the old value stored at `key`, or `null` when `key` did not exist.
     * @since 6.2
     */
    suspend fun setGet(key: K, value: V, setArgs: SetArgs): V?

    /**
     * Sets or clears the bit at offset in the string value stored at key.
     *
     * @param key the key.
     * @param offset the offset type: long.
     * @param value the value type: string.
     * @return Long integer-reply the original bit value stored at <em>offset</em>.
     */
    suspend fun setbit(key: K, offset: Long, value: Int): Long?

    /**
     * Set the value and expiration of a key.
     *
     * @param key the key.
     * @param seconds the seconds type: long.
     * @param value the value.
     * @return String simple-string-reply.
     */
    suspend fun setex(key: K, seconds: Long, value: V): String?

    /**
     * Set the value and expiration in milliseconds of a key.
     *
     * @param key the key.
     * @param milliseconds the milliseconds type: long.
     * @param value the value.
     * @return String simple-string-reply.
     */
    suspend fun psetex(key: K, milliseconds: Long, value: V): String?

    /**
     * Set the value of a key, only if the key does not exist.
     *
     * @param key the key.
     * @param value the value.
     * @return Boolean integer-reply specifically:
     *
     *         `1` if the key was set `0` if the key was not set.
     */
    suspend fun setnx(key: K, value: V): Boolean?

    /**
     * Overwrite part of a string at key starting at the specified offset.
     *
     * @param key the key.
     * @param offset the offset type: long.
     * @param value the value.
     * @return Long integer-reply the length of the string after it was modified by the command.
     */
    suspend fun setrange(key: K, offset: Long, value: V): Long?

    /**
     * The STRALGO command implements complex algorithms that operate on strings. This method uses the LCS algorithm (longest
     * common substring).
     *
     * <ul>
     * <li>Without modifiers the string representing the longest common substring is returned.</li>
     * <li>When [StrAlgoArgs#justLen LEN] is given the command returns the length of the longest common substring.</li>
     * <li>When [StrAlgoArgs#withIdx IDX] is given the command returns an array with the LCS length and all the ranges
     * in both the strings, start and end offset for each string, where there are matches. When
     * [StrAlgoArgs#withMatchLen WITHMATCHLEN] is given each array representing a match will also have the length of the
     * match.</li>
     * </ul>
     *
     * @param strAlgoArgs command arguments.
     * @return StringMatchResult.
     * @since 6.0
     */
    suspend fun stralgoLcs(strAlgoArgs: StrAlgoArgs): StringMatchResult?

    /**
     * Get the length of the value stored in a key.
     *
     * @param key the key.
     * @return Long integer-reply the length of the string at `key`, or `0` when `key` does not exist.
     */
    suspend fun strlen(key: K): Long?

}

