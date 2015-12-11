.class Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;)V
    .locals 0

    .prologue
    .line 99
    iput-object p1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 6

    .prologue
    .line 106
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->a(Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 107
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->d(Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;)Lbu;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->b(Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;)Z

    move-result v4

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->c(Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;)I

    move-result v5

    move v1, p2

    move v2, p3

    move v3, p4

    invoke-interface/range {v0 .. v5}, Lbu;->a(IIIZI)V

    .line 108
    :cond_0
    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 2

    .prologue
    .line 102
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;->a(Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreListFragment;Z)Z

    .line 103
    return-void
.end method
