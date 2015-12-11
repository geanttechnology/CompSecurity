.class Lcom/commonsware/MergeAdapter$EnabledSackAdapter;
.super Lcom/commonsware/SackOfViewsAdapter;
.source "MergeAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/commonsware/MergeAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "EnabledSackAdapter"
.end annotation


# direct methods
.method public constructor <init>(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/view/View;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 350
    .local p1, "views":Ljava/util/List;, "Ljava/util/List<Landroid/view/View;>;"
    invoke-direct {p0, p1}, Lcom/commonsware/SackOfViewsAdapter;-><init>(Ljava/util/List;)V

    .line 351
    return-void
.end method


# virtual methods
.method public areAllItemsEnabled()Z
    .locals 1

    .prologue
    .line 355
    const/4 v0, 0x1

    return v0
.end method

.method public isEnabled(I)Z
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 360
    const/4 v0, 0x1

    return v0
.end method
