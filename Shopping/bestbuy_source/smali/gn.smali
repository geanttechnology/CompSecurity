.class public final enum Lgn;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lgn;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Lgn;

.field public static final enum b:Lgn;

.field public static final enum c:Lgn;

.field private static final synthetic f:[Lgn;


# instance fields
.field public d:Ljava/lang/String;

.field public e:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 33
    new-instance v0, Lgn;

    const-string v1, "PROD"

    const-string v2, "https://bbyoffer.appspot.com"

    const-string v3, "kEmhttwd7z7LR9O"

    invoke-direct {v0, v1, v4, v2, v3}, Lgn;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lgn;->a:Lgn;

    .line 34
    new-instance v0, Lgn;

    const-string v1, "QA"

    const-string v2, "https://bbyoffer-int.appspot.com"

    const-string v3, "kEmhttwd7z7LR9O"

    invoke-direct {v0, v1, v5, v2, v3}, Lgn;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lgn;->b:Lgn;

    .line 35
    new-instance v0, Lgn;

    const-string v1, "CUSTOM"

    const-string v2, ""

    const-string v3, ""

    invoke-direct {v0, v1, v6, v2, v3}, Lgn;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lgn;->c:Lgn;

    .line 32
    const/4 v0, 0x3

    new-array v0, v0, [Lgn;

    sget-object v1, Lgn;->a:Lgn;

    aput-object v1, v0, v4

    sget-object v1, Lgn;->b:Lgn;

    aput-object v1, v0, v5

    sget-object v1, Lgn;->c:Lgn;

    aput-object v1, v0, v6

    sput-object v0, Lgn;->f:[Lgn;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 40
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 41
    iput-object p3, p0, Lgn;->d:Ljava/lang/String;

    .line 42
    iput-object p4, p0, Lgn;->e:Ljava/lang/String;

    .line 43
    return-void
.end method

.method public static a(Ljava/lang/String;)Lgn;
    .locals 1

    .prologue
    .line 32
    const-class v0, Lgn;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lgn;

    return-object v0
.end method
