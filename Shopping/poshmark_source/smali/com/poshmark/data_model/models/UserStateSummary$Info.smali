.class Lcom/poshmark/data_model/models/UserStateSummary$Info;
.super Ljava/lang/Object;
.source "UserStateSummary.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/UserStateSummary;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Info"
.end annotation


# instance fields
.field public posh_protect:Ljava/lang/String;

.field public returns:Ljava/lang/String;

.field public shipping:Ljava/lang/String;

.field public shipping_returns:Ljava/lang/String;

.field final synthetic this$0:Lcom/poshmark/data_model/models/UserStateSummary;


# direct methods
.method constructor <init>(Lcom/poshmark/data_model/models/UserStateSummary;)V
    .locals 0

    .prologue
    .line 50
    iput-object p1, p0, Lcom/poshmark/data_model/models/UserStateSummary$Info;->this$0:Lcom/poshmark/data_model/models/UserStateSummary;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
