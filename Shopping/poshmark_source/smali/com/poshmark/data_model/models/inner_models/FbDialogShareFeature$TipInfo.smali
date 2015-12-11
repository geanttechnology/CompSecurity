.class public Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;
.super Ljava/lang/Object;
.source "FbDialogShareFeature.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "TipInfo"
.end annotation


# instance fields
.field public background_color:Ljava/lang/String;

.field public message:Ljava/lang/String;

.field public text_color:Ljava/lang/String;

.field final synthetic this$0:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;

.field public use_separate_section_for_tip:Z


# direct methods
.method public constructor <init>(Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;)V
    .locals 1

    .prologue
    .line 119
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;->this$0:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 123
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;->use_separate_section_for_tip:Z

    return-void
.end method
