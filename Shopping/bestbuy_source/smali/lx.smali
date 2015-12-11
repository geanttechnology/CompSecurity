.class final enum Llx;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Llx;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum a:Llx;

.field public static final enum b:Llx;

.field public static final enum c:Llx;

.field private static final synthetic d:[Llx;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 26
    new-instance v0, Llx;

    const-string v1, "PREVIEW"

    invoke-direct {v0, v1, v2}, Llx;-><init>(Ljava/lang/String;I)V

    sput-object v0, Llx;->a:Llx;

    new-instance v0, Llx;

    const-string v1, "SUCCESS"

    invoke-direct {v0, v1, v3}, Llx;-><init>(Ljava/lang/String;I)V

    sput-object v0, Llx;->b:Llx;

    new-instance v0, Llx;

    const-string v1, "DONE"

    invoke-direct {v0, v1, v4}, Llx;-><init>(Ljava/lang/String;I)V

    sput-object v0, Llx;->c:Llx;

    .line 25
    const/4 v0, 0x3

    new-array v0, v0, [Llx;

    sget-object v1, Llx;->a:Llx;

    aput-object v1, v0, v2

    sget-object v1, Llx;->b:Llx;

    aput-object v1, v0, v3

    sget-object v1, Llx;->c:Llx;

    aput-object v1, v0, v4

    sput-object v0, Llx;->d:[Llx;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method
