.class Lcom/poshmark/data_model/models/TrackingGoal$Node;
.super Ljava/lang/Object;
.source "TrackingGoal.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/TrackingGoal;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Node"
.end annotation


# instance fields
.field nm:Ljava/lang/String;

.field final synthetic this$0:Lcom/poshmark/data_model/models/TrackingGoal;

.field v:Ljava/lang/Object;


# direct methods
.method constructor <init>(Lcom/poshmark/data_model/models/TrackingGoal;Ljava/lang/String;Ljava/lang/Object;)V
    .locals 0
    .param p2, "tag"    # Ljava/lang/String;
    .param p3, "payload"    # Ljava/lang/Object;

    .prologue
    .line 31
    iput-object p1, p0, Lcom/poshmark/data_model/models/TrackingGoal$Node;->this$0:Lcom/poshmark/data_model/models/TrackingGoal;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    iput-object p2, p0, Lcom/poshmark/data_model/models/TrackingGoal$Node;->nm:Ljava/lang/String;

    .line 33
    iput-object p3, p0, Lcom/poshmark/data_model/models/TrackingGoal$Node;->v:Ljava/lang/Object;

    .line 34
    return-void
.end method
