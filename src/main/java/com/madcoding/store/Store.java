package com.madcoding.store;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;

public interface Store<TYPE,IDTYPE> {
	CompletableFuture<TYPE> add(TYPE obj);
	CompletableFuture<Void> remove(IDTYPE id);
	CompletableFuture<TYPE> searchById(IDTYPE id);
	CompletableFuture<List<TYPE>> search(Predicate<TYPE> condition);
	int registered();
}
