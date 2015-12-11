.class public Lcom/amazon/ansel/fetch/tools/ref/StrongObjectReference;
.super Ljava/lang/Object;
.source "StrongObjectReference.java"

# interfaces
.implements Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/amazon/ansel/fetch/tools/ref/ObjectReference",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final reference:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 6
    .local p0, "this":Lcom/amazon/ansel/fetch/tools/ref/StrongObjectReference;, "Lcom/amazon/ansel/fetch/tools/ref/StrongObjectReference<TT;>;"
    .local p1, "reference":Ljava/lang/Object;, "TT;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 7
    iput-object p1, p0, Lcom/amazon/ansel/fetch/tools/ref/StrongObjectReference;->reference:Ljava/lang/Object;

    .line 8
    return-void
.end method


# virtual methods
.method public get()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 12
    .local p0, "this":Lcom/amazon/ansel/fetch/tools/ref/StrongObjectReference;, "Lcom/amazon/ansel/fetch/tools/ref/StrongObjectReference<TT;>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/tools/ref/StrongObjectReference;->reference:Ljava/lang/Object;

    return-object v0
.end method
