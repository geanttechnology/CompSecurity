.class public Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;
.super Ljava/lang/Object;
.source "FeedItemStoryType.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;
    }
.end annotation


# instance fields
.field currentStory:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->INVALID:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->currentStory:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    .line 36
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "storyTypeString"    # Ljava/lang/String;

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->INVALID:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->currentStory:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    .line 39
    invoke-virtual {p0, p1}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->setStoryType(Ljava/lang/String;)V

    .line 40
    return-void
.end method


# virtual methods
.method public getStoryType()Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->currentStory:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    return-object v0
.end method

.method public isStoryTypeValid()Z
    .locals 2

    .prologue
    .line 47
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->currentStory:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->INVALID:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    if-eq v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setStoryType(Ljava/lang/String;)V
    .locals 1
    .param p1, "storyTypeString"    # Ljava/lang/String;

    .prologue
    .line 51
    if-eqz p1, :cond_0

    .line 52
    const-string v0, "CLOSET_ADD_SIFU"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 53
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->CLOSET_ADD_SIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->currentStory:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    .line 94
    :cond_0
    :goto_0
    return-void

    .line 54
    :cond_1
    const-string v0, "CLOSET_ADD_SIFUSOCIAL"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 55
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->CLOSET_ADD_SIFU_SOCIAL:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->currentStory:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    goto :goto_0

    .line 56
    :cond_2
    const-string v0, "CLOSET_ADD_MIFU"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 57
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->CLOSET_ADD_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->currentStory:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    goto :goto_0

    .line 58
    :cond_3
    const-string v0, "CLOSET_UPDATE_SIFU"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 59
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->CLOSET_UPDATE_SIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->currentStory:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    goto :goto_0

    .line 60
    :cond_4
    const-string v0, "CLOSET_UPDATE_SIFUSOCIAL"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 61
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->CLOSET_UPDATE_SIFU_SOCIAL:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->currentStory:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    goto :goto_0

    .line 62
    :cond_5
    const-string v0, "CLOSET_UPDATE_MIFU"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 63
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->CLOSET_UPDATE_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->currentStory:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    goto :goto_0

    .line 64
    :cond_6
    const-string v0, "LISTING_SHARE_SIFU"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 65
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->LISTING_SHARE_SIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->currentStory:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    goto :goto_0

    .line 66
    :cond_7
    const-string v0, "LISTING_SHARE_SIFUSOCIAL"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 67
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->LISTING_SHARE_SIFU_SOCIAL:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->currentStory:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    goto :goto_0

    .line 68
    :cond_8
    const-string v0, "LISTING_SHARE_MIFU"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 69
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->LISTING_SHARE_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->currentStory:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    goto :goto_0

    .line 70
    :cond_9
    const-string v0, "SELF_SHARE_SIFU"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 71
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->SELF_SHARE_SIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->currentStory:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    goto :goto_0

    .line 72
    :cond_a
    const-string v0, "SELF_SHARE_SIFUSOCIAL"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 73
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->SELF_SHARE_SIFU_SOCIAL:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->currentStory:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    goto/16 :goto_0

    .line 74
    :cond_b
    const-string v0, "SELF_SHARE_MIFU"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_c

    .line 75
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->SELF_SHARE_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->currentStory:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    goto/16 :goto_0

    .line 76
    :cond_c
    const-string v0, "BRAND_ADD_MIFU"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_d

    .line 77
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->BRAND_ADD_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->currentStory:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    goto/16 :goto_0

    .line 78
    :cond_d
    const-string v0, "BRAND_CHECKOUT_MIFU"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_e

    .line 79
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->BRAND_CHECKOUT_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->currentStory:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    goto/16 :goto_0

    .line 80
    :cond_e
    const-string v0, "BRAND_LISTING_ADD_MIFU"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_f

    .line 81
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->BRAND_CHECKOUT_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->currentStory:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    goto/16 :goto_0

    .line 82
    :cond_f
    const-string v0, "BRAND_JUSTIN_MIFU"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_10

    .line 83
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->BRAND_JUSTIN_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->currentStory:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    goto/16 :goto_0

    .line 84
    :cond_10
    const-string v0, "BRAND_RECOMMEND_MIFU"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_11

    .line 85
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->BRAND_RECOMMEND_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->currentStory:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    goto/16 :goto_0

    .line 86
    :cond_11
    const-string v0, "CLOSET_RECOMMEND_MIFU"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_12

    .line 87
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->CLOSET_RECOMMEND_MIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->currentStory:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    goto/16 :goto_0

    .line 88
    :cond_12
    const-string v0, "CPU_SIFU"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_13

    .line 89
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->POSHPOST_SIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->currentStory:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    goto/16 :goto_0

    .line 91
    :cond_13
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->INVALID:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->currentStory:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    goto/16 :goto_0
.end method
