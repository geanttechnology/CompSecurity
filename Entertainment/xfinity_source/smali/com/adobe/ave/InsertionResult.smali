.class public Lcom/adobe/ave/InsertionResult;
.super Ljava/lang/Object;
.source "InsertionResult.java"


# instance fields
.field public insertedBeforeReadHead:Z

.field public periodIndex:I


# direct methods
.method private constructor <init>(IZ)V
    .locals 0
    .param p1, "aPeriodIndex"    # I
    .param p2, "aInsertedBeforeReadHead"    # Z

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    iput p1, p0, Lcom/adobe/ave/InsertionResult;->periodIndex:I

    .line 40
    iput-boolean p2, p0, Lcom/adobe/ave/InsertionResult;->insertedBeforeReadHead:Z

    .line 41
    return-void
.end method
