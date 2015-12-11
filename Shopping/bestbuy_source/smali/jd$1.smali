.class Ljd$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ljd;->c()V
.end annotation


# instance fields
.field final synthetic a:Ljd;


# direct methods
.method constructor <init>(Ljd;)V
    .locals 0

    .prologue
    .line 99
    iput-object p1, p0, Ljd$1;->a:Ljd;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Ljd$1;->a:Ljd;

    invoke-virtual {v0}, Ljd;->d()V

    .line 103
    return-void
.end method
