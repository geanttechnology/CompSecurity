.class public abstract Lcom/poshmark/data_model/models/PMData;
.super Ljava/lang/Object;
.source "PMData.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/PMData$NextMaxID;
    }
.end annotation


# static fields
.field public static DATA_COL:Ljava/lang/String;

.field public static ID_COL:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 8
    const-string v0, "_id"

    sput-object v0, Lcom/poshmark/data_model/models/PMData;->ID_COL:Ljava/lang/String;

    .line 9
    const-string v0, "item"

    sput-object v0, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    return-void
.end method


# virtual methods
.method public append(Lcom/poshmark/data_model/models/PMData;)V
    .locals 0
    .param p1, "data"    # Lcom/poshmark/data_model/models/PMData;

    .prologue
    .line 11
    return-void
.end method

.method public createHashAndRemoveDups()V
    .locals 0

    .prologue
    .line 14
    return-void
.end method

.method public fillCursor(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;)V
    .locals 0
    .param p1, "cursor"    # Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .prologue
    .line 12
    return-void
.end method

.method public getNextPageMaxValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 13
    const/4 v0, 0x0

    return-object v0
.end method
