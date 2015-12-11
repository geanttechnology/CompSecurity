.class public Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;
.super Ljava/lang/Object;
.source "UserStateSummary.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/UserStateSummary;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "UserInfo"
.end annotation


# instance fields
.field public ab_segment:Lcom/poshmark/data_model/models/UserStateSummary$Segment;

.field public size_available:Ljava/lang/String;

.field final synthetic this$0:Lcom/poshmark/data_model/models/UserStateSummary;


# direct methods
.method public constructor <init>(Lcom/poshmark/data_model/models/UserStateSummary;)V
    .locals 0

    .prologue
    .line 57
    iput-object p1, p0, Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;->this$0:Lcom/poshmark/data_model/models/UserStateSummary;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAbSegment()Ljava/lang/String;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;->ab_segment:Lcom/poshmark/data_model/models/UserStateSummary$Segment;

    if-eqz v0, :cond_0

    .line 72
    iget-object v0, p0, Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;->ab_segment:Lcom/poshmark/data_model/models/UserStateSummary$Segment;

    iget-object v0, v0, Lcom/poshmark/data_model/models/UserStateSummary$Segment;->sign_up:Ljava/lang/String;

    .line 74
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isMySizeAvailable()Z
    .locals 2

    .prologue
    .line 63
    iget-object v0, p0, Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;->size_available:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;->size_available:Ljava/lang/String;

    const-string v1, "none"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 64
    const/4 v0, 0x1

    .line 66
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
