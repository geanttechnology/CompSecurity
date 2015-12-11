.class Liz$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lnn;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Liz;->c()V
.end annotation


# instance fields
.field final synthetic a:Liz;


# direct methods
.method constructor <init>(Liz;)V
    .locals 0

    .prologue
    .line 68
    iput-object p1, p0, Liz$2;->a:Liz;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 71
    const/4 v0, 0x0

    invoke-static {v0}, Liz;->a(I)I

    .line 72
    return-void
.end method
