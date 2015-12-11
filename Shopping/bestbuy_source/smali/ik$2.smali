.class Lik$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lnn;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lik;->c()V
.end annotation


# instance fields
.field final synthetic a:Lik;


# direct methods
.method constructor <init>(Lik;)V
    .locals 0

    .prologue
    .line 77
    iput-object p1, p0, Lik$2;->a:Lik;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 79
    const/4 v0, 0x0

    invoke-static {v0}, Lik;->a(I)I

    .line 80
    return-void
.end method
