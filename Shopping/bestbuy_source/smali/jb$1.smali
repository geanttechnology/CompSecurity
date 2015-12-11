.class Ljb$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ljb;->c()V
.end annotation


# instance fields
.field final synthetic a:Ljb;


# direct methods
.method constructor <init>(Ljb;)V
    .locals 0

    .prologue
    .line 82
    iput-object p1, p0, Ljb$1;->a:Ljb;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Ljb$1;->a:Ljb;

    invoke-virtual {v0}, Ljb;->d()V

    .line 86
    return-void
.end method
