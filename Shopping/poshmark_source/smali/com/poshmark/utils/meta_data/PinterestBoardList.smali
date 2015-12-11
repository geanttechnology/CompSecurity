.class public Lcom/poshmark/utils/meta_data/PinterestBoardList;
.super Ljava/lang/Object;
.source "PinterestBoardList.java"


# instance fields
.field public boards:Ljava/util/ArrayList;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "data"
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/poshmark/utils/meta_data/PinterestBoard;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getBoards()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/poshmark/utils/meta_data/PinterestBoard;",
            ">;"
        }
    .end annotation

    .prologue
    .line 14
    iget-object v0, p0, Lcom/poshmark/utils/meta_data/PinterestBoardList;->boards:Ljava/util/ArrayList;

    return-object v0
.end method
