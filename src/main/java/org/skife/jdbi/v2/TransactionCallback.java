/*
 * Copyright 2004 - 2011 Brian McCallister
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.skife.jdbi.v2;

/**
 * Used as a callback which guarantees that the inTransaction method is invoked in
 * a transaction, and will be committed or rolled back as specified.
 */
public interface TransactionCallback<ReturnType> extends Transaction<ReturnType, Handle>
{
    /**
     * Execute in a transaction. Will be committed afterwards, or rolled back if a transaction
     * is thrown
     * <p>
     * If the transaction fails a {@link org.skife.jdbi.v2.exceptions.TransactionFailedException}
     * will be thrown from the {@link Handle#inTransaction(TransactionCallback<ReturnType>)}
     *
     * @param handle a transactional handle instance which can be used in the callback
     * @param status a handle on the transaction, kind of
     * @return Something to return from {@link Handle#inTransaction(TransactionCallback<ReturnType>)}
     * @throws Exception will cause the transaction be aborted
     */
    public ReturnType inTransaction(Handle handle, TransactionStatus status) throws Exception;
}
