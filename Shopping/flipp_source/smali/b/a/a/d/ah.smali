.class final Lb/a/a/d/ah;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lb/a/a/d/al;
.implements Lb/a/a/d/am;


# static fields
.field static final a:Lb/a/a/d/ah;


# instance fields
.field private final b:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 1545
    new-instance v0, Lb/a/a/d/ah;

    const-string v1, ""

    invoke-direct {v0, v1}, Lb/a/a/d/ah;-><init>(Ljava/lang/String;)V

    sput-object v0, Lb/a/a/d/ah;->a:Lb/a/a/d/ah;

    return-void
.end method

.method constructor <init>(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1548
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1549
    iput-object p1, p0, Lb/a/a/d/ah;->b:Ljava/lang/String;

    .line 1550
    return-void
.end method
