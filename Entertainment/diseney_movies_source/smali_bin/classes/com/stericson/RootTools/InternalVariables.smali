.class Lcom/stericson/RootTools/InternalVariables;
.super Ljava/lang/Object;
.source "InternalVariables.java"


# static fields
.field protected static TAG:Ljava/lang/String;

.field protected static accessGiven:Z

.field protected static busyboxVersion:Ljava/lang/String;

.field protected static getSpaceFor:Ljava/lang/String;

.field protected static mounts:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/stericson/RootTools/Mount;",
            ">;"
        }
    .end annotation
.end field

.field protected static nativeToolsReady:Z

.field protected static path:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected static pid:Ljava/lang/String;

.field protected static space:[Ljava/lang/String;

.field protected static symlinks:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/stericson/RootTools/Symlink;",
            ">;"
        }
    .end annotation
.end field

.field protected static timeout:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 37
    const-string v0, "RootTools v1.6"

    sput-object v0, Lcom/stericson/RootTools/InternalVariables;->TAG:Ljava/lang/String;

    .line 38
    sput-boolean v1, Lcom/stericson/RootTools/InternalVariables;->accessGiven:Z

    .line 39
    sput-boolean v1, Lcom/stericson/RootTools/InternalVariables;->nativeToolsReady:Z

    .line 47
    const/16 v0, 0x2710

    sput v0, Lcom/stericson/RootTools/InternalVariables;->timeout:I

    .line 30
    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
