.class Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$1$1;
.super Ljava/lang/Object;
.source "BookmarksFragment.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$1;->execute()Lcom/comcast/cim/cmasl/utils/container/Tuple4;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcom/xfinity/playerlib/model/Favorite;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$1;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$1;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$1;

    .prologue
    .line 64
    iput-object p1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$1$1;->this$1:Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public compare(Lcom/xfinity/playerlib/model/Favorite;Lcom/xfinity/playerlib/model/Favorite;)I
    .locals 2
    .param p1, "lhs"    # Lcom/xfinity/playerlib/model/Favorite;
    .param p2, "rhs"    # Lcom/xfinity/playerlib/model/Favorite;

    .prologue
    .line 67
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/Favorite;->getCreated()Ljava/util/Date;

    move-result-object v0

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/Favorite;->getCreated()Ljava/util/Date;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/Date;->compareTo(Ljava/util/Date;)I

    move-result v0

    return v0
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 64
    check-cast p1, Lcom/xfinity/playerlib/model/Favorite;

    check-cast p2, Lcom/xfinity/playerlib/model/Favorite;

    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$1$1;->compare(Lcom/xfinity/playerlib/model/Favorite;Lcom/xfinity/playerlib/model/Favorite;)I

    move-result v0

    return v0
.end method
