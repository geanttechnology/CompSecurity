.class public Lcom/poshmark/utils/ItemPair;
.super Ljava/lang/Object;
.source "ItemPair.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private item1:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field

.field private item2:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;TT;)V"
        }
    .end annotation

    .prologue
    .line 7
    .local p0, "this":Lcom/poshmark/utils/ItemPair;, "Lcom/poshmark/utils/ItemPair<TT;>;"
    .local p1, "item1":Ljava/lang/Object;, "TT;"
    .local p2, "item2":Ljava/lang/Object;, "TT;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    iput-object p1, p0, Lcom/poshmark/utils/ItemPair;->item1:Ljava/lang/Object;

    .line 9
    iput-object p2, p0, Lcom/poshmark/utils/ItemPair;->item2:Ljava/lang/Object;

    .line 10
    return-void
.end method


# virtual methods
.method public getLeftItem()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 13
    .local p0, "this":Lcom/poshmark/utils/ItemPair;, "Lcom/poshmark/utils/ItemPair<TT;>;"
    iget-object v0, p0, Lcom/poshmark/utils/ItemPair;->item1:Ljava/lang/Object;

    return-object v0
.end method

.method public getRightItem()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 17
    .local p0, "this":Lcom/poshmark/utils/ItemPair;, "Lcom/poshmark/utils/ItemPair<TT;>;"
    iget-object v0, p0, Lcom/poshmark/utils/ItemPair;->item2:Ljava/lang/Object;

    return-object v0
.end method
