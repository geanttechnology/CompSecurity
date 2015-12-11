.class public Lcom/poshmark/data_model/models/EventContext;
.super Ljava/lang/Object;
.source "EventContext.java"


# instance fields
.field public by_display_handle:Ljava/lang/String;

.field public by_full_name:Ljava/lang/String;

.field public by_id:Ljava/lang/String;

.field public by_picture_url:Ljava/lang/String;

.field public by_username:Ljava/lang/String;

.field public created_at:Ljava/lang/String;

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
.method public copy(Lcom/poshmark/data_model/models/EventContext;)V
    .locals 1
    .param p1, "eventContext"    # Lcom/poshmark/data_model/models/EventContext;

    .prologue
    .line 16
    if-eqz p1, :cond_0

    .line 17
    iget-object v0, p1, Lcom/poshmark/data_model/models/EventContext;->id:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/EventContext;->id:Ljava/lang/String;

    .line 18
    iget-object v0, p1, Lcom/poshmark/data_model/models/EventContext;->by_id:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/EventContext;->by_id:Ljava/lang/String;

    .line 19
    iget-object v0, p1, Lcom/poshmark/data_model/models/EventContext;->by_username:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/EventContext;->by_username:Ljava/lang/String;

    .line 20
    iget-object v0, p1, Lcom/poshmark/data_model/models/EventContext;->by_display_handle:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/EventContext;->by_display_handle:Ljava/lang/String;

    .line 21
    iget-object v0, p1, Lcom/poshmark/data_model/models/EventContext;->by_full_name:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/EventContext;->by_full_name:Ljava/lang/String;

    .line 22
    iget-object v0, p1, Lcom/poshmark/data_model/models/EventContext;->created_at:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/EventContext;->created_at:Ljava/lang/String;

    .line 23
    iget-object v0, p1, Lcom/poshmark/data_model/models/EventContext;->by_picture_url:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/EventContext;->by_picture_url:Ljava/lang/String;

    .line 25
    :cond_0
    return-void
.end method
