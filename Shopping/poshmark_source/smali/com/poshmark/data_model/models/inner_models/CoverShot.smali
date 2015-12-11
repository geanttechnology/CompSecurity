.class public Lcom/poshmark/data_model/models/inner_models/CoverShot;
.super Ljava/lang/Object;
.source "CoverShot.java"


# instance fields
.field content_type:Ljava/lang/String;

.field created_at:Ljava/lang/String;

.field public id:Ljava/lang/String;

.field public url:Ljava/lang/String;

.field public url_small:Ljava/lang/String;

.field public url_thumb:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public copy(Lcom/poshmark/data_model/models/inner_models/CoverShot;)V
    .locals 1
    .param p1, "cover_shot"    # Lcom/poshmark/data_model/models/inner_models/CoverShot;

    .prologue
    .line 12
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/CoverShot;->id:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/CoverShot;->id:Ljava/lang/String;

    .line 13
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/CoverShot;->created_at:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/CoverShot;->created_at:Ljava/lang/String;

    .line 14
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url_small:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url_small:Ljava/lang/String;

    .line 15
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/CoverShot;->content_type:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/CoverShot;->content_type:Ljava/lang/String;

    .line 16
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url:Ljava/lang/String;

    .line 17
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url_thumb:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url_thumb:Ljava/lang/String;

    .line 18
    return-void
.end method
