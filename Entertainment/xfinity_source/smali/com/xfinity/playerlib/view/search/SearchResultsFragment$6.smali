.class Lcom/xfinity/playerlib/view/search/SearchResultsFragment$6;
.super Ljava/lang/Object;
.source "SearchResultsFragment.java"

# interfaces
.implements Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher",
        "<",
        "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .prologue
    .line 426
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$6;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public programMatchesTag(Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/xfinity/playerlib/model/tags/OrderedTag;)Z
    .locals 1
    .param p1, "program"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .param p2, "tag"    # Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .prologue
    .line 428
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getGenres()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p2}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public bridge synthetic programMatchesTag(Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/xfinity/playerlib/model/tags/Tag;)Z
    .locals 1

    .prologue
    .line 426
    check-cast p2, Lcom/xfinity/playerlib/model/tags/OrderedTag;

    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$6;->programMatchesTag(Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/xfinity/playerlib/model/tags/OrderedTag;)Z

    move-result v0

    return v0
.end method
