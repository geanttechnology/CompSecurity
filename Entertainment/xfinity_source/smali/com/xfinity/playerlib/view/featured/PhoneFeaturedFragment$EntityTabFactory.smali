.class Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$EntityTabFactory;
.super Ljava/lang/Object;
.source "PhoneFeaturedFragment.java"

# interfaces
.implements Landroid/widget/TabHost$TabContentFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "EntityTabFactory"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;


# direct methods
.method private constructor <init>(Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;)V
    .locals 0

    .prologue
    .line 125
    iput-object p1, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$EntityTabFactory;->this$0:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;
    .param p2, "x1"    # Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$1;

    .prologue
    .line 125
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$EntityTabFactory;-><init>(Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;)V

    return-void
.end method


# virtual methods
.method public createTabContent(Ljava/lang/String;)Landroid/view/View;
    .locals 3
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 128
    new-instance v0, Landroid/view/View;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$EntityTabFactory;->this$0:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 129
    .local v0, "view":Landroid/view/View;
    invoke-virtual {v0, v2}, Landroid/view/View;->setMinimumHeight(I)V

    .line 130
    invoke-virtual {v0, v2}, Landroid/view/View;->setMinimumWidth(I)V

    .line 132
    return-object v0
.end method
