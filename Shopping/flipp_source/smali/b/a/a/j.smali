.class final Lb/a/a/j;
.super Lb/a/a/b/c;
.source "SourceFile"


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 643
    invoke-direct {p0}, Lb/a/a/b/c;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Lb/a/a/i;)Lb/a/a/a;
    .locals 0

    .prologue
    .line 641
    return-object p0
.end method

.method public final a()Lb/a/a/i;
    .locals 1

    .prologue
    .line 635
    const/4 v0, 0x0

    return-object v0
.end method

.method public final b()Lb/a/a/a;
    .locals 0

    .prologue
    .line 638
    return-object p0
.end method

.method public final toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 644
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
