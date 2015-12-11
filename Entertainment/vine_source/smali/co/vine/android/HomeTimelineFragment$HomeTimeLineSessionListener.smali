.class Lco/vine/android/HomeTimelineFragment$HomeTimeLineSessionListener;
.super Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;
.source "HomeTimelineFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/HomeTimelineFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "HomeTimeLineSessionListener"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/HomeTimelineFragment;


# direct methods
.method private constructor <init>(Lco/vine/android/HomeTimelineFragment;)V
    .locals 0

    .prologue
    .line 219
    iput-object p1, p0, Lco/vine/android/HomeTimelineFragment$HomeTimeLineSessionListener;->this$0:Lco/vine/android/HomeTimelineFragment;

    invoke-direct {p0, p1}, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;-><init>(Lco/vine/android/BaseTimelineFragment;)V

    return-void
.end method

.method synthetic constructor <init>(Lco/vine/android/HomeTimelineFragment;Lco/vine/android/HomeTimelineFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lco/vine/android/HomeTimelineFragment;
    .param p2, "x1"    # Lco/vine/android/HomeTimelineFragment$1;

    .prologue
    .line 219
    invoke-direct {p0, p1}, Lco/vine/android/HomeTimelineFragment$HomeTimeLineSessionListener;-><init>(Lco/vine/android/HomeTimelineFragment;)V

    return-void
.end method


# virtual methods
.method public onFetchClientFlagsComplete(Ljava/lang/String;ILjava/lang/String;Lco/vine/android/api/VineClientFlags;Z)V
    .locals 2
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "clientFlags"    # Lco/vine/android/api/VineClientFlags;
    .param p5, "showClientFlagsBanner"    # Z

    .prologue
    .line 224
    invoke-super/range {p0 .. p5}, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->onFetchClientFlagsComplete(Ljava/lang/String;ILjava/lang/String;Lco/vine/android/api/VineClientFlags;Z)V

    .line 227
    const/16 v0, 0xc8

    if-ne p2, v0, :cond_0

    iget-object v0, p0, Lco/vine/android/HomeTimelineFragment$HomeTimeLineSessionListener;->this$0:Lco/vine/android/HomeTimelineFragment;

    invoke-virtual {v0}, Lco/vine/android/HomeTimelineFragment;->isFocused()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 228
    iget-object v0, p0, Lco/vine/android/HomeTimelineFragment$HomeTimeLineSessionListener;->this$0:Lco/vine/android/HomeTimelineFragment;

    # getter for: Lco/vine/android/HomeTimelineFragment;->mInviteBottomBanner:Landroid/widget/FrameLayout;
    invoke-static {v0}, Lco/vine/android/HomeTimelineFragment;->access$100(Lco/vine/android/HomeTimelineFragment;)Landroid/widget/FrameLayout;

    move-result-object v0

    if-eqz v0, :cond_0

    if-eqz p5, :cond_0

    .line 229
    iget-object v0, p0, Lco/vine/android/HomeTimelineFragment$HomeTimeLineSessionListener;->this$0:Lco/vine/android/HomeTimelineFragment;

    # getter for: Lco/vine/android/HomeTimelineFragment;->mInviteBottomBanner:Landroid/widget/FrameLayout;
    invoke-static {v0}, Lco/vine/android/HomeTimelineFragment;->access$100(Lco/vine/android/HomeTimelineFragment;)Landroid/widget/FrameLayout;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 232
    :cond_0
    return-void
.end method

.method public onMobileDataNetworkActivated()V
    .locals 2

    .prologue
    .line 236
    invoke-super {p0}, Lco/vine/android/BaseTimelineFragment$TimeLineSessionListener;->onMobileDataNetworkActivated()V

    .line 237
    iget-object v0, p0, Lco/vine/android/HomeTimelineFragment$HomeTimeLineSessionListener;->this$0:Lco/vine/android/HomeTimelineFragment;

    invoke-virtual {v0}, Lco/vine/android/HomeTimelineFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lco/vine/android/util/ClientFlagsHelper;->shouldShowClientFlagsBanner(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/HomeTimelineFragment$HomeTimeLineSessionListener;->this$0:Lco/vine/android/HomeTimelineFragment;

    invoke-virtual {v0}, Lco/vine/android/HomeTimelineFragment;->isFocused()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 238
    iget-object v0, p0, Lco/vine/android/HomeTimelineFragment$HomeTimeLineSessionListener;->this$0:Lco/vine/android/HomeTimelineFragment;

    # getter for: Lco/vine/android/HomeTimelineFragment;->mInviteBottomBanner:Landroid/widget/FrameLayout;
    invoke-static {v0}, Lco/vine/android/HomeTimelineFragment;->access$100(Lco/vine/android/HomeTimelineFragment;)Landroid/widget/FrameLayout;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/HomeTimelineFragment$HomeTimeLineSessionListener;->this$0:Lco/vine/android/HomeTimelineFragment;

    # getter for: Lco/vine/android/HomeTimelineFragment;->mInviteBottomBanner:Landroid/widget/FrameLayout;
    invoke-static {v0}, Lco/vine/android/HomeTimelineFragment;->access$100(Lco/vine/android/HomeTimelineFragment;)Landroid/widget/FrameLayout;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 240
    :cond_0
    return-void
.end method
