.class public final enum Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;
.super Ljava/lang/Enum;
.source "Configuration.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/sdk/availability/Configuration;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "PersistenceFormat"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

.field public static final enum DROPBOX:Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

.field public static final enum EXTERNAL:Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

.field public static final enum NONE:Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

.field public static final enum PRIVATE_DATA:Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;


# instance fields
.field private name:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 90
    new-instance v0, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    const-string/jumbo v1, "NONE"

    const-string/jumbo v2, "None"

    invoke-direct {v0, v1, v3, v2}, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->NONE:Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    .line 93
    new-instance v0, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    const-string/jumbo v1, "DROPBOX"

    const-string/jumbo v2, "DropBox"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->DROPBOX:Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    .line 96
    new-instance v0, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    const-string/jumbo v1, "PRIVATE_DATA"

    const-string/jumbo v2, "PrivateData"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->PRIVATE_DATA:Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    .line 99
    new-instance v0, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    const-string/jumbo v1, "EXTERNAL"

    const-string/jumbo v2, "External"

    invoke-direct {v0, v1, v6, v2}, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->EXTERNAL:Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    .line 88
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    sget-object v1, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->NONE:Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->DROPBOX:Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->PRIVATE_DATA:Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->EXTERNAL:Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    aput-object v1, v0, v6

    sput-object v0, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->$VALUES:[Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 109
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 110
    iput-object p3, p0, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->name:Ljava/lang/String;

    .line 111
    return-void
.end method

.method public static fromString(Ljava/lang/String;)Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;
    .locals 2
    .param p0, "string"    # Ljava/lang/String;

    .prologue
    .line 128
    sget-object v0, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->NONE:Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    .line 129
    .local v0, "result":Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;
    sget-object v1, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->DROPBOX:Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    invoke-virtual {v1}, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 130
    sget-object v0, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->DROPBOX:Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    .line 136
    :cond_0
    :goto_0
    return-object v0

    .line 131
    :cond_1
    sget-object v1, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->PRIVATE_DATA:Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    invoke-virtual {v1}, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 132
    sget-object v0, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->PRIVATE_DATA:Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    goto :goto_0

    .line 133
    :cond_2
    sget-object v1, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->EXTERNAL:Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    invoke-virtual {v1}, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 134
    sget-object v0, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->EXTERNAL:Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    goto :goto_0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 88
    const-class v0, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    return-object v0
.end method

.method public static values()[Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;
    .locals 1

    .prologue
    .line 88
    sget-object v0, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->$VALUES:[Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    invoke-virtual {v0}, [Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;

    return-object v0
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 118
    iget-object v0, p0, Lcom/amazon/sdk/availability/Configuration$PersistenceFormat;->name:Ljava/lang/String;

    return-object v0
.end method
