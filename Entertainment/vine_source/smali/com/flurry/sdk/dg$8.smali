.class Lcom/flurry/sdk/dg$8;
.super Lcom/flurry/sdk/fc;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/flurry/sdk/dg;->x()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/flurry/sdk/dg;


# direct methods
.method constructor <init>(Lcom/flurry/sdk/dg;)V
    .locals 0

    .prologue
    .line 453
    iput-object p1, p0, Lcom/flurry/sdk/dg$8;->a:Lcom/flurry/sdk/dg;

    invoke-direct {p0}, Lcom/flurry/sdk/fc;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 456
    iget-object v0, p0, Lcom/flurry/sdk/dg$8;->a:Lcom/flurry/sdk/dg;

    invoke-static {v0}, Lcom/flurry/sdk/dg;->e(Lcom/flurry/sdk/dg;)V

    .line 457
    return-void
.end method
