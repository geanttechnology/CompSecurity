.class public Lcom/poshmark/data_model/customcursors/CustomMatrixCursor$RowBuilder;
.super Ljava/lang/Object;
.source "CustomMatrixCursor.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "RowBuilder"
.end annotation


# instance fields
.field private final endIndex:I

.field private index:I

.field final synthetic this$0:Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;


# direct methods
.method constructor <init>(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;II)V
    .locals 0
    .param p2, "index"    # I
    .param p3, "endIndex"    # I

    .prologue
    .line 211
    iput-object p1, p0, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor$RowBuilder;->this$0:Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 212
    iput p2, p0, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor$RowBuilder;->index:I

    .line 213
    iput p3, p0, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor$RowBuilder;->endIndex:I

    .line 214
    return-void
.end method


# virtual methods
.method public add(Ljava/lang/Object;)Lcom/poshmark/data_model/customcursors/CustomMatrixCursor$RowBuilder;
    .locals 3
    .param p1, "columnValue"    # Ljava/lang/Object;

    .prologue
    .line 224
    iget v0, p0, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor$RowBuilder;->index:I

    iget v1, p0, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor$RowBuilder;->endIndex:I

    if-ne v0, v1, :cond_0

    .line 225
    new-instance v0, Landroid/database/CursorIndexOutOfBoundsException;

    const-string v1, "No more columns left."

    invoke-direct {v0, v1}, Landroid/database/CursorIndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 229
    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor$RowBuilder;->this$0:Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    # getter for: Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->data:[Ljava/lang/Object;
    invoke-static {v0}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->access$000(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;)[Ljava/lang/Object;

    move-result-object v0

    iget v1, p0, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor$RowBuilder;->index:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor$RowBuilder;->index:I

    aput-object p1, v0, v1

    .line 230
    return-object p0
.end method
