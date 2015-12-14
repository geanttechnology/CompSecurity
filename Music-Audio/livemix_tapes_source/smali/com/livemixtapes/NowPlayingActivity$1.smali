.class Lcom/livemixtapes/NowPlayingActivity$1;
.super Ljava/lang/Object;
.source "NowPlayingActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/NowPlayingActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/NowPlayingActivity;


# direct methods
.method constructor <init>(Lcom/livemixtapes/NowPlayingActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/NowPlayingActivity$1;->this$0:Lcom/livemixtapes/NowPlayingActivity;

    .line 291
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 294
    new-instance v0, Lcom/livemixtapes/CommentsPopup;

    .line 295
    iget-object v1, p0, Lcom/livemixtapes/NowPlayingActivity$1;->this$0:Lcom/livemixtapes/NowPlayingActivity;

    sget-object v2, Lcom/livemixtapes/NowPlayingActivity;->mContext:Landroid/content/Context;

    sget-object v3, Lcom/livemixtapes/NowPlayingActivity;->mixtape:Ljava/util/Map;

    .line 294
    invoke-direct {v0, v1, v2, v3}, Lcom/livemixtapes/CommentsPopup;-><init>(Landroid/app/Activity;Landroid/content/Context;Ljava/util/Map;)V

    .line 296
    .local v0, "popup":Lcom/livemixtapes/CommentsPopup;
    iget-object v1, p0, Lcom/livemixtapes/NowPlayingActivity$1;->this$0:Lcom/livemixtapes/NowPlayingActivity;

    iget-object v1, v1, Lcom/livemixtapes/NowPlayingActivity;->mFrameLayout:Landroid/widget/FrameLayout;

    sget-object v2, Lcom/livemixtapes/NowPlayingActivity;->share:Lcom/livemixtapes/ui/FadeImageButton;

    invoke-virtual {v0, v1, v2}, Lcom/livemixtapes/CommentsPopup;->showPopup(Landroid/widget/FrameLayout;Landroid/widget/ImageButton;)V

    .line 297
    return-void
.end method
