.class public interface abstract Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;
.super Ljava/lang/Object;
.source "IRetailSearchDataProvider.java"


# virtual methods
.method public abstract clearAssets()V
.end method

.method public abstract clearSuggestions()V
.end method

.method public abstract deletePersonalizedSuggestions(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;
.end method

.method public abstract fetchAssets(Lcom/amazon/retailsearch/data/assets/AssetFetchType;)V
.end method

.method public abstract getBadge(Ljava/lang/String;)Landroid/graphics/Bitmap;
.end method

.method public abstract getPersonalizedSuggestions(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;
.end method

.method public abstract getPersonalizedSuggestions(Ljava/lang/String;Z)Lcom/amazon/searchapp/retailsearch/model/PersonalizedSuggestions;
.end method

.method public abstract getSearchSuggestions(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/model/SearchSuggestions;
.end method
