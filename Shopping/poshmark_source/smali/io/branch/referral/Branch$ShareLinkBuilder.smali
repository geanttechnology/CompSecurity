.class public Lio/branch/referral/Branch$ShareLinkBuilder;
.super Ljava/lang/Object;
.source "Branch.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/branch/referral/Branch;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ShareLinkBuilder"
.end annotation


# instance fields
.field private final activity_:Landroid/app/Activity;

.field private final branch_:Lio/branch/referral/Branch;

.field private callback_:Lio/branch/referral/Branch$BranchLinkShareListener;

.field private copyURlText_:Ljava/lang/String;

.field private copyUrlIcon_:Landroid/graphics/drawable/Drawable;

.field private defaultURL_:Ljava/lang/String;

.field private moreOptionIcon_:Landroid/graphics/drawable/Drawable;

.field private moreOptionText_:Ljava/lang/String;

.field private preferredOptions_:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lio/branch/referral/SharingHelper$SHARE_WITH;",
            ">;"
        }
    .end annotation
.end field

.field private shareMsg_:Ljava/lang/String;

.field private shareSub_:Ljava/lang/String;

.field shortLinkBuilder_:Lio/branch/referral/BranchShortLinkBuilder;

.field private urlCopiedMessage_:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lio/branch/referral/BranchShortLinkBuilder;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "shortLinkBuilder"    # Lio/branch/referral/BranchShortLinkBuilder;

    .prologue
    .line 3765
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    invoke-direct {p0, p1, v0}, Lio/branch/referral/Branch$ShareLinkBuilder;-><init>(Landroid/app/Activity;Lorg/json/JSONObject;)V

    .line 3766
    iput-object p2, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->shortLinkBuilder_:Lio/branch/referral/BranchShortLinkBuilder;

    .line 3767
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lorg/json/JSONObject;)V
    .locals 5
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "parameters"    # Lorg/json/JSONObject;

    .prologue
    const/4 v4, 0x0

    .line 3732
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3711
    iput-object v4, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->callback_:Lio/branch/referral/Branch$BranchLinkShareListener;

    .line 3733
    iput-object p1, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->activity_:Landroid/app/Activity;

    .line 3734
    # getter for: Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;
    invoke-static {}, Lio/branch/referral/Branch;->access$2300()Lio/branch/referral/Branch;

    move-result-object v2

    iput-object v2, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->branch_:Lio/branch/referral/Branch;

    .line 3735
    new-instance v2, Lio/branch/referral/BranchShortLinkBuilder;

    invoke-direct {v2, p1}, Lio/branch/referral/BranchShortLinkBuilder;-><init>(Landroid/content/Context;)V

    iput-object v2, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->shortLinkBuilder_:Lio/branch/referral/BranchShortLinkBuilder;

    .line 3737
    :try_start_0
    invoke-virtual {p2}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v1

    .line 3738
    .local v1, "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 3739
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 3740
    .local v0, "key":Ljava/lang/String;
    iget-object v3, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->shortLinkBuilder_:Lio/branch/referral/BranchShortLinkBuilder;

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v3, v0, v2}, Lio/branch/referral/BranchShortLinkBuilder;->addParameters(Ljava/lang/String;Ljava/lang/String;)Lio/branch/referral/BranchUrlBuilder;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 3742
    .end local v0    # "key":Ljava/lang/String;
    .end local v1    # "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :catch_0
    move-exception v2

    .line 3744
    :cond_0
    const-string v2, ""

    iput-object v2, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->shareMsg_:Ljava/lang/String;

    .line 3745
    iput-object v4, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->callback_:Lio/branch/referral/Branch$BranchLinkShareListener;

    .line 3746
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->preferredOptions_:Ljava/util/ArrayList;

    .line 3747
    iput-object v4, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->defaultURL_:Ljava/lang/String;

    .line 3749
    invoke-virtual {p1}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x1080045

    invoke-static {v2, v3}, Lio/branch/referral/BranchUtil;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    iput-object v2, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->moreOptionIcon_:Landroid/graphics/drawable/Drawable;

    .line 3750
    const-string v2, "More..."

    iput-object v2, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->moreOptionText_:Ljava/lang/String;

    .line 3752
    invoke-virtual {p1}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x108004e

    invoke-static {v2, v3}, Lio/branch/referral/BranchUtil;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    iput-object v2, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->copyUrlIcon_:Landroid/graphics/drawable/Drawable;

    .line 3753
    const-string v2, "Copy link"

    iput-object v2, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->copyURlText_:Ljava/lang/String;

    .line 3754
    const-string v2, "Copied link to clipboard!"

    iput-object v2, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->urlCopiedMessage_:Ljava/lang/String;

    .line 3755
    return-void
.end method


# virtual methods
.method public addParam(Ljava/lang/String;Ljava/lang/String;)Lio/branch/referral/Branch$ShareLinkBuilder;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 3889
    :try_start_0
    iget-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->shortLinkBuilder_:Lio/branch/referral/BranchShortLinkBuilder;

    invoke-virtual {v0, p1, p2}, Lio/branch/referral/BranchShortLinkBuilder;->addParameters(Ljava/lang/String;Ljava/lang/String;)Lio/branch/referral/BranchUrlBuilder;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 3893
    :goto_0
    return-object p0

    .line 3890
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public addPreferredSharingOption(Lio/branch/referral/SharingHelper$SHARE_WITH;)Lio/branch/referral/Branch$ShareLinkBuilder;
    .locals 1
    .param p1, "preferredOption"    # Lio/branch/referral/SharingHelper$SHARE_WITH;

    .prologue
    .line 3862
    iget-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->preferredOptions_:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 3863
    return-object p0
.end method

.method public addPreferredSharingOptions(Ljava/util/ArrayList;)Lio/branch/referral/Branch$ShareLinkBuilder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lio/branch/referral/SharingHelper$SHARE_WITH;",
            ">;)",
            "Lio/branch/referral/Branch$ShareLinkBuilder;"
        }
    .end annotation

    .prologue
    .line 3876
    .local p1, "preferredOptions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lio/branch/referral/SharingHelper$SHARE_WITH;>;"
    iget-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->preferredOptions_:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 3877
    return-object p0
.end method

.method public addTag(Ljava/lang/String;)Lio/branch/referral/Branch$ShareLinkBuilder;
    .locals 1
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 3800
    iget-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->shortLinkBuilder_:Lio/branch/referral/BranchShortLinkBuilder;

    invoke-virtual {v0, p1}, Lio/branch/referral/BranchShortLinkBuilder;->addTag(Ljava/lang/String;)Lio/branch/referral/BranchUrlBuilder;

    .line 3801
    return-object p0
.end method

.method public addTags(Ljava/util/ArrayList;)Lio/branch/referral/Branch$ShareLinkBuilder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Lio/branch/referral/Branch$ShareLinkBuilder;"
        }
    .end annotation

    .prologue
    .line 3813
    .local p1, "tags":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->shortLinkBuilder_:Lio/branch/referral/BranchShortLinkBuilder;

    invoke-virtual {v0, p1}, Lio/branch/referral/BranchShortLinkBuilder;->addTags(Ljava/util/List;)Lio/branch/referral/BranchUrlBuilder;

    .line 3814
    return-object p0
.end method

.method public getActivity()Landroid/app/Activity;
    .locals 1

    .prologue
    .line 4008
    iget-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->activity_:Landroid/app/Activity;

    return-object v0
.end method

.method public getBranch()Lio/branch/referral/Branch;
    .locals 1

    .prologue
    .line 4016
    iget-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->branch_:Lio/branch/referral/Branch;

    return-object v0
.end method

.method public getCallback()Lio/branch/referral/Branch$BranchLinkShareListener;
    .locals 1

    .prologue
    .line 4028
    iget-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->callback_:Lio/branch/referral/Branch$BranchLinkShareListener;

    return-object v0
.end method

.method public getCopyURlText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 4048
    iget-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->copyURlText_:Ljava/lang/String;

    return-object v0
.end method

.method public getCopyUrlIcon()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 4044
    iget-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->copyUrlIcon_:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public getDefaultURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 4032
    iget-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->defaultURL_:Ljava/lang/String;

    return-object v0
.end method

.method public getMoreOptionIcon()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 4036
    iget-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->moreOptionIcon_:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public getMoreOptionText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 4040
    iget-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->moreOptionText_:Ljava/lang/String;

    return-object v0
.end method

.method public getPreferredOptions()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lio/branch/referral/SharingHelper$SHARE_WITH;",
            ">;"
        }
    .end annotation

    .prologue
    .line 4012
    iget-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->preferredOptions_:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getShareMsg()Ljava/lang/String;
    .locals 1

    .prologue
    .line 4020
    iget-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->shareMsg_:Ljava/lang/String;

    return-object v0
.end method

.method public getShareSub()Ljava/lang/String;
    .locals 1

    .prologue
    .line 4024
    iget-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->shareSub_:Ljava/lang/String;

    return-object v0
.end method

.method public getShortLinkBuilder()Lio/branch/referral/BranchShortLinkBuilder;
    .locals 1

    .prologue
    .line 4056
    iget-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->shortLinkBuilder_:Lio/branch/referral/BranchShortLinkBuilder;

    return-object v0
.end method

.method public getUrlCopiedMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 4052
    iget-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->urlCopiedMessage_:Ljava/lang/String;

    return-object v0
.end method

.method public setAlias(Ljava/lang/String;)Lio/branch/referral/Branch$ShareLinkBuilder;
    .locals 1
    .param p1, "alias"    # Ljava/lang/String;

    .prologue
    .line 3979
    iget-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->shortLinkBuilder_:Lio/branch/referral/BranchShortLinkBuilder;

    invoke-virtual {v0, p1}, Lio/branch/referral/BranchShortLinkBuilder;->setAlias(Ljava/lang/String;)Lio/branch/referral/BranchShortLinkBuilder;

    .line 3980
    return-object p0
.end method

.method public setCallback(Lio/branch/referral/Branch$BranchLinkShareListener;)Lio/branch/referral/Branch$ShareLinkBuilder;
    .locals 0
    .param p1, "callback"    # Lio/branch/referral/Branch$BranchLinkShareListener;

    .prologue
    .line 3848
    iput-object p1, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->callback_:Lio/branch/referral/Branch$BranchLinkShareListener;

    .line 3849
    return-object p0
.end method

.method public setCopyUrlStyle(III)Lio/branch/referral/Branch$ShareLinkBuilder;
    .locals 1
    .param p1, "drawableIconID"    # I
    .param p2, "stringLabelID"    # I
    .param p3, "stringMessageID"    # I

    .prologue
    .line 3960
    iget-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->activity_:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p1}, Lio/branch/referral/BranchUtil;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->copyUrlIcon_:Landroid/graphics/drawable/Drawable;

    .line 3961
    iget-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->activity_:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->copyURlText_:Ljava/lang/String;

    .line 3962
    iget-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->activity_:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->urlCopiedMessage_:Ljava/lang/String;

    .line 3963
    return-object p0
.end method

.method public setCopyUrlStyle(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;)Lio/branch/referral/Branch$ShareLinkBuilder;
    .locals 0
    .param p1, "icon"    # Landroid/graphics/drawable/Drawable;
    .param p2, "label"    # Ljava/lang/String;
    .param p3, "message"    # Ljava/lang/String;

    .prologue
    .line 3945
    iput-object p1, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->copyUrlIcon_:Landroid/graphics/drawable/Drawable;

    .line 3946
    iput-object p2, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->copyURlText_:Ljava/lang/String;

    .line 3947
    iput-object p3, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->urlCopiedMessage_:Ljava/lang/String;

    .line 3948
    return-object p0
.end method

.method public setDefaultURL(Ljava/lang/String;)Lio/branch/referral/Branch$ShareLinkBuilder;
    .locals 0
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 3903
    iput-object p1, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->defaultURL_:Ljava/lang/String;

    .line 3904
    return-object p0
.end method

.method public setFeature(Ljava/lang/String;)Lio/branch/referral/Branch$ShareLinkBuilder;
    .locals 1
    .param p1, "feature"    # Ljava/lang/String;

    .prologue
    .line 3825
    iget-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->shortLinkBuilder_:Lio/branch/referral/BranchShortLinkBuilder;

    invoke-virtual {v0, p1}, Lio/branch/referral/BranchShortLinkBuilder;->setFeature(Ljava/lang/String;)Lio/branch/referral/BranchShortLinkBuilder;

    .line 3826
    return-object p0
.end method

.method public setMatchDuration(I)Lio/branch/referral/Branch$ShareLinkBuilder;
    .locals 1
    .param p1, "matchDuration"    # I

    .prologue
    .line 3991
    iget-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->shortLinkBuilder_:Lio/branch/referral/BranchShortLinkBuilder;

    invoke-virtual {v0, p1}, Lio/branch/referral/BranchShortLinkBuilder;->setDuration(I)Lio/branch/referral/BranchShortLinkBuilder;

    .line 3992
    return-object p0
.end method

.method public setMessage(Ljava/lang/String;)Lio/branch/referral/Branch$ShareLinkBuilder;
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 3776
    iput-object p1, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->shareMsg_:Ljava/lang/String;

    .line 3777
    return-object p0
.end method

.method public setMoreOptionStyle(II)Lio/branch/referral/Branch$ShareLinkBuilder;
    .locals 1
    .param p1, "drawableIconID"    # I
    .param p2, "stringLabelID"    # I

    .prologue
    .line 3930
    iget-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->activity_:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p1}, Lio/branch/referral/BranchUtil;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->moreOptionIcon_:Landroid/graphics/drawable/Drawable;

    .line 3931
    iget-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->activity_:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->moreOptionText_:Ljava/lang/String;

    .line 3932
    return-object p0
.end method

.method public setMoreOptionStyle(Landroid/graphics/drawable/Drawable;Ljava/lang/String;)Lio/branch/referral/Branch$ShareLinkBuilder;
    .locals 0
    .param p1, "icon"    # Landroid/graphics/drawable/Drawable;
    .param p2, "label"    # Ljava/lang/String;

    .prologue
    .line 3916
    iput-object p1, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->moreOptionIcon_:Landroid/graphics/drawable/Drawable;

    .line 3917
    iput-object p2, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->moreOptionText_:Ljava/lang/String;

    .line 3918
    return-object p0
.end method

.method public setShortLinkBuilderInternal(Lio/branch/referral/BranchShortLinkBuilder;)V
    .locals 0
    .param p1, "shortLinkBuilder"    # Lio/branch/referral/BranchShortLinkBuilder;

    .prologue
    .line 3996
    iput-object p1, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->shortLinkBuilder_:Lio/branch/referral/BranchShortLinkBuilder;

    .line 3997
    return-void
.end method

.method public setStage(Ljava/lang/String;)Lio/branch/referral/Branch$ShareLinkBuilder;
    .locals 1
    .param p1, "stage"    # Ljava/lang/String;

    .prologue
    .line 3837
    iget-object v0, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->shortLinkBuilder_:Lio/branch/referral/BranchShortLinkBuilder;

    invoke-virtual {v0, p1}, Lio/branch/referral/BranchShortLinkBuilder;->setStage(Ljava/lang/String;)Lio/branch/referral/BranchShortLinkBuilder;

    .line 3838
    return-object p0
.end method

.method public setSubject(Ljava/lang/String;)Lio/branch/referral/Branch$ShareLinkBuilder;
    .locals 0
    .param p1, "subject"    # Ljava/lang/String;

    .prologue
    .line 3787
    iput-object p1, p0, Lio/branch/referral/Branch$ShareLinkBuilder;->shareSub_:Ljava/lang/String;

    .line 3788
    return-object p0
.end method

.method public shareLink()V
    .locals 1

    .prologue
    .line 4004
    # getter for: Lio/branch/referral/Branch;->branchReferral_:Lio/branch/referral/Branch;
    invoke-static {}, Lio/branch/referral/Branch;->access$2300()Lio/branch/referral/Branch;

    move-result-object v0

    # invokes: Lio/branch/referral/Branch;->shareLink(Lio/branch/referral/Branch$ShareLinkBuilder;)V
    invoke-static {v0, p0}, Lio/branch/referral/Branch;->access$2900(Lio/branch/referral/Branch;Lio/branch/referral/Branch$ShareLinkBuilder;)V

    .line 4005
    return-void
.end method
