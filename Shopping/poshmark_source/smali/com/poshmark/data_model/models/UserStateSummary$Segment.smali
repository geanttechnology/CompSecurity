.class Lcom/poshmark/data_model/models/UserStateSummary$Segment;
.super Ljava/lang/Object;
.source "UserStateSummary.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/UserStateSummary;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Segment"
.end annotation


# instance fields
.field public sign_up:Ljava/lang/String;

.field final synthetic this$0:Lcom/poshmark/data_model/models/UserStateSummary;


# direct methods
.method constructor <init>(Lcom/poshmark/data_model/models/UserStateSummary;)V
    .locals 0

    .prologue
    .line 79
    iput-object p1, p0, Lcom/poshmark/data_model/models/UserStateSummary$Segment;->this$0:Lcom/poshmark/data_model/models/UserStateSummary;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
