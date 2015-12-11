.class Lii$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lii;->c()V
.end annotation


# instance fields
.field final synthetic a:Lii;


# direct methods
.method constructor <init>(Lii;)V
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lii$1;->a:Lii;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lii$1;->a:Lii;

    invoke-virtual {v0}, Lii;->d()V

    .line 73
    return-void
.end method
