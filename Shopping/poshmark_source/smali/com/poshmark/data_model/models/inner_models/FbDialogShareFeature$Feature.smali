.class Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;
.super Ljava/lang/Object;
.source "FbDialogShareFeature.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Feature"
.end annotation


# instance fields
.field enabled:Z

.field fb_brand_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

.field fb_closet_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

.field fb_invite_friends_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

.field fb_listing_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

.field fb_party_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

.field fb_showroom_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

.field final synthetic this$0:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;

.field use_fb_dialog:Z

.field use_separate_section_for_tip:Z


# direct methods
.method constructor <init>(Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 107
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->this$0:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 108
    iput-boolean v0, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->enabled:Z

    .line 115
    iput-boolean v0, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->use_fb_dialog:Z

    .line 116
    iput-boolean v0, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->use_separate_section_for_tip:Z

    return-void
.end method
