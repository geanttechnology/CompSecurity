.class Lje$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lje;->c()V
.end annotation


# instance fields
.field final synthetic a:Lje;


# direct methods
.method constructor <init>(Lje;)V
    .locals 0

    .prologue
    .line 64
    iput-object p1, p0, Lje$1;->a:Lje;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 67
    invoke-static {}, Lje;->f()I

    .line 68
    iget-object v0, p0, Lje$1;->a:Lje;

    invoke-virtual {v0}, Lje;->d()V

    .line 69
    return-void
.end method
