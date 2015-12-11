.class public Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$AccessibleOnScrollListener;
.super Ljava/lang/Object;
.source "PhoneFeaturedFragment.java"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "AccessibleOnScrollListener"
.end annotation


# instance fields
.field private description:Ljava/lang/String;

.field final synthetic this$0:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;


# direct methods
.method protected constructor <init>(Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    .prologue
    .line 262
    iput-object p1, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$AccessibleOnScrollListener;->this$0:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 2
    .param p1, "absListView"    # Landroid/widget/AbsListView;
    .param p2, "firstVisibleItem"    # I
    .param p3, "lastVisibleItem"    # I
    .param p4, "totalCount"    # I

    .prologue
    .line 281
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$AccessibleOnScrollListener;->description:Ljava/lang/String;

    invoke-static {p1, v1, p2, p3, p4}, Lcom/comcast/cim/utils/UIPresentationUtil;->getAbsListStateDescription(Landroid/view/View;Ljava/lang/String;III)Ljava/lang/String;

    move-result-object v0

    .line 285
    .local v0, "content_description":Ljava/lang/String;
    invoke-virtual {p1, v0}, Landroid/widget/AbsListView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 286
    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 0
    .param p1, "absListView"    # Landroid/widget/AbsListView;
    .param p2, "i"    # I

    .prologue
    .line 273
    return-void
.end method

.method public setDescription(Ljava/lang/String;)V
    .locals 0
    .param p1, "description"    # Ljava/lang/String;

    .prologue
    .line 267
    iput-object p1, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$AccessibleOnScrollListener;->description:Ljava/lang/String;

    .line 268
    return-void
.end method
