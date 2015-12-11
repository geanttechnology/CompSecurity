.class public Lcom/poshmark/data_model/models/inner_models/Comment;
.super Ljava/lang/Object;
.source "Comment.java"


# instance fields
.field public comment:Ljava/lang/String;

.field public created_at:Ljava/lang/String;

.field public creator_display_handle:Ljava/lang/String;

.field public creator_fb_id:Ljava/lang/String;

.field public creator_full_name:Ljava/lang/String;

.field public creator_id:Ljava/lang/String;

.field public creator_picture_url:Ljava/lang/String;

.field public creator_username:Ljava/lang/String;

.field public id:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public copy(Lcom/poshmark/data_model/models/inner_models/Comment;)V
    .locals 1
    .param p1, "newComment"    # Lcom/poshmark/data_model/models/inner_models/Comment;

    .prologue
    .line 54
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Comment;->creator_picture_url:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Comment;->creator_picture_url:Ljava/lang/String;

    .line 55
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Comment;->id:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Comment;->id:Ljava/lang/String;

    .line 56
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Comment;->creator_username:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Comment;->creator_username:Ljava/lang/String;

    .line 57
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Comment;->creator_full_name:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Comment;->creator_full_name:Ljava/lang/String;

    .line 58
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Comment;->created_at:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Comment;->created_at:Ljava/lang/String;

    .line 59
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Comment;->creator_fb_id:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Comment;->creator_fb_id:Ljava/lang/String;

    .line 60
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Comment;->creator_display_handle:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Comment;->creator_display_handle:Ljava/lang/String;

    .line 61
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Comment;->comment:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Comment;->comment:Ljava/lang/String;

    .line 62
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/Comment;->creator_id:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Comment;->creator_id:Ljava/lang/String;

    .line 63
    return-void
.end method

.method public getComment()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Comment;->comment:Ljava/lang/String;

    return-object v0
.end method

.method public getCommenterDisplayHandle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Comment;->creator_display_handle:Ljava/lang/String;

    return-object v0
.end method

.method public getCommenterFbId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Comment;->creator_fb_id:Ljava/lang/String;

    return-object v0
.end method

.method public getCommenterId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Comment;->creator_id:Ljava/lang/String;

    return-object v0
.end method

.method public getCommenterName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Comment;->creator_username:Ljava/lang/String;

    return-object v0
.end method

.method public getCommenterPicture()Ljava/lang/String;
    .locals 4

    .prologue
    .line 23
    const/4 v0, 0x0

    .line 24
    .local v0, "url":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/Comment;->creator_picture_url:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 25
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Comment;->creator_picture_url:Ljava/lang/String;

    .line 30
    :cond_0
    :goto_0
    return-object v0

    .line 26
    :cond_1
    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/Comment;->creator_fb_id:Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 27
    const-string v0, "https://graph.facebook.com/%s/picture?width=100&height=100"

    .line 28
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/poshmark/data_model/models/inner_models/Comment;->creator_fb_id:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getCreatedAt()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Comment;->created_at:Ljava/lang/String;

    return-object v0
.end method
