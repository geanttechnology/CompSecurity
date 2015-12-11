.class public Lcom/poshmark/data_model/models/PMData$NextMaxID;
.super Ljava/lang/Object;
.source "PMData.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/PMData;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "NextMaxID"
.end annotation


# instance fields
.field next_max_id:Ljava/lang/String;

.field final synthetic this$0:Lcom/poshmark/data_model/models/PMData;


# direct methods
.method public constructor <init>(Lcom/poshmark/data_model/models/PMData;)V
    .locals 0

    .prologue
    .line 18
    iput-object p1, p0, Lcom/poshmark/data_model/models/PMData$NextMaxID;->this$0:Lcom/poshmark/data_model/models/PMData;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
