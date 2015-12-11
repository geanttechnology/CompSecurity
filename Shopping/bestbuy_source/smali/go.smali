.class public Lgo;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static a:Lgp;

.field private static final b:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 12
    const-class v0, Lgo;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lgo;->b:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    return-void
.end method

.method public static a()Lgp;
    .locals 1

    .prologue
    .line 54
    sget-object v0, Lgo;->a:Lgp;

    return-object v0
.end method
