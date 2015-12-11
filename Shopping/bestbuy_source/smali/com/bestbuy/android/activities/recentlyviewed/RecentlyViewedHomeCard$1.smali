.class Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;)V
    .locals 0

    .prologue
    .line 89
    iput-object p1, p0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard$1;->a:Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 2

    .prologue
    .line 92
    invoke-virtual {p1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .line 93
    const/4 v0, 0x0

    return v0
.end method
