.class public Lcom/poshmark/data_model/models/inner_models/FeedContext;
.super Ljava/lang/Object;
.source "FeedContext.java"


# instance fields
.field public shared:Z

.field public shared_at:Ljava/lang/String;

.field shared_by_fb_user_id:Ljava/lang/String;

.field shared_by_id:Ljava/lang/String;

.field shared_by_picture_url:Ljava/lang/String;

.field public shared_by_username:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public copy(Lcom/poshmark/data_model/models/inner_models/FeedContext;)V
    .locals 1
    .param p1, "feedContext"    # Lcom/poshmark/data_model/models/inner_models/FeedContext;

    .prologue
    .line 12
    if-eqz p1, :cond_0

    .line 13
    iget-boolean v0, p1, Lcom/poshmark/data_model/models/inner_models/FeedContext;->shared:Z

    iput-boolean v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedContext;->shared:Z

    .line 14
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/FeedContext;->shared_by_username:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedContext;->shared_by_username:Ljava/lang/String;

    .line 15
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/FeedContext;->shared_by_picture_url:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedContext;->shared_by_picture_url:Ljava/lang/String;

    .line 16
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/FeedContext;->shared_at:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedContext;->shared_at:Ljava/lang/String;

    .line 17
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/FeedContext;->shared_by_id:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedContext;->shared_by_id:Ljava/lang/String;

    .line 18
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/FeedContext;->shared_by_fb_user_id:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FeedContext;->shared_by_fb_user_id:Ljava/lang/String;

    .line 20
    :cond_0
    return-void
.end method
