.class interface abstract Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher;
.super Ljava/lang/Object;
.source "SearchResultsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x60a
    name = "TagMatcher"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T::",
        "Lcom/xfinity/playerlib/model/tags/Tag;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# virtual methods
.method public abstract programMatchesTag(Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/xfinity/playerlib/model/tags/Tag;)Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            "TT;)Z"
        }
    .end annotation
.end method
