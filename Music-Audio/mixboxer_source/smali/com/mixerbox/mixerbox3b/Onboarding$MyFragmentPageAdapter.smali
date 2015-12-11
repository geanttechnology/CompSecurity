.class public Lcom/mixerbox/mixerbox3b/Onboarding$MyFragmentPageAdapter;
.super Landroid/support/v4/app/FragmentPagerAdapter;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/Onboarding;


# direct methods
.method public constructor <init>(Lcom/mixerbox/mixerbox3b/Onboarding;Landroid/support/v4/app/FragmentManager;)V
    .locals 0

    .prologue
    .line 299
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/Onboarding$MyFragmentPageAdapter;->this$0:Lcom/mixerbox/mixerbox3b/Onboarding;

    .line 300
    invoke-direct {p0, p2}, Landroid/support/v4/app/FragmentPagerAdapter;-><init>(Landroid/support/v4/app/FragmentManager;)V

    .line 301
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 304
    const/4 v0, 0x3

    return v0
.end method

.method public getItem(I)Landroid/support/v4/app/Fragment;
    .locals 1

    .prologue
    .line 308
    packed-switch p1, :pswitch_data_0

    .line 316
    const/4 v0, 0x0

    :goto_0
    return-object v0

    .line 310
    :pswitch_0
    invoke-static {p1}, Lcom/mixerbox/mixerbox3b/classes/MyFragment;->newInstance(I)Lcom/mixerbox/mixerbox3b/classes/MyFragment;

    move-result-object v0

    goto :goto_0

    .line 312
    :pswitch_1
    invoke-static {p1}, Lcom/mixerbox/mixerbox3b/classes/MyFragment;->newInstance(I)Lcom/mixerbox/mixerbox3b/classes/MyFragment;

    move-result-object v0

    goto :goto_0

    .line 314
    :pswitch_2
    invoke-static {p1}, Lcom/mixerbox/mixerbox3b/classes/MyFragment;->newInstance(I)Lcom/mixerbox/mixerbox3b/classes/MyFragment;

    move-result-object v0

    goto :goto_0

    .line 308
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
