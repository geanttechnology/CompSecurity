.class public final enum Lcom/amazon/retailsearch/data/search/ResultStream$Status;
.super Ljava/lang/Enum;
.source "ResultStream.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/data/search/ResultStream;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Status"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/retailsearch/data/search/ResultStream$Status;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/retailsearch/data/search/ResultStream$Status;

.field public static final enum Done:Lcom/amazon/retailsearch/data/search/ResultStream$Status;

.field public static final enum Error:Lcom/amazon/retailsearch/data/search/ResultStream$Status;

.field public static final enum None:Lcom/amazon/retailsearch/data/search/ResultStream$Status;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 82
    new-instance v0, Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    const-string/jumbo v1, "None"

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/data/search/ResultStream$Status;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/data/search/ResultStream$Status;->None:Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    .line 86
    new-instance v0, Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    const-string/jumbo v1, "Done"

    invoke-direct {v0, v1, v3}, Lcom/amazon/retailsearch/data/search/ResultStream$Status;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/data/search/ResultStream$Status;->Done:Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    .line 87
    new-instance v0, Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    const-string/jumbo v1, "Error"

    invoke-direct {v0, v1, v4}, Lcom/amazon/retailsearch/data/search/ResultStream$Status;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/data/search/ResultStream$Status;->Error:Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    .line 81
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    sget-object v1, Lcom/amazon/retailsearch/data/search/ResultStream$Status;->None:Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/retailsearch/data/search/ResultStream$Status;->Done:Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/retailsearch/data/search/ResultStream$Status;->Error:Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/retailsearch/data/search/ResultStream$Status;->$VALUES:[Lcom/amazon/retailsearch/data/search/ResultStream$Status;

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
    .line 81
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/retailsearch/data/search/ResultStream$Status;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 81
    const-class v0, Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    return-object v0
.end method

.method public static values()[Lcom/amazon/retailsearch/data/search/ResultStream$Status;
    .locals 1

    .prologue
    .line 81
    sget-object v0, Lcom/amazon/retailsearch/data/search/ResultStream$Status;->$VALUES:[Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    invoke-virtual {v0}, [Lcom/amazon/retailsearch/data/search/ResultStream$Status;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/retailsearch/data/search/ResultStream$Status;

    return-object v0
.end method
