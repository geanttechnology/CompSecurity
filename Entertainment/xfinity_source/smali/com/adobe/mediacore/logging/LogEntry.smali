.class public Lcom/adobe/mediacore/logging/LogEntry;
.super Ljava/lang/Object;


# instance fields
.field private final dateTime:Ljava/lang/String;

.field private final message:Ljava/lang/String;

.field private final tag:Ljava/lang/String;

.field private final verbosity:Lcom/adobe/mediacore/logging/Logger$Verbosity;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/adobe/mediacore/logging/Logger$Verbosity;Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/adobe/mediacore/logging/LogEntry;->dateTime:Ljava/lang/String;

    iput-object p2, p0, Lcom/adobe/mediacore/logging/LogEntry;->message:Ljava/lang/String;

    iput-object p3, p0, Lcom/adobe/mediacore/logging/LogEntry;->verbosity:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    iput-object p4, p0, Lcom/adobe/mediacore/logging/LogEntry;->tag:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getDateTime()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/logging/LogEntry;->dateTime:Ljava/lang/String;

    return-object v0
.end method

.method public getMessage()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/logging/LogEntry;->message:Ljava/lang/String;

    return-object v0
.end method

.method public getTag()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/logging/LogEntry;->tag:Ljava/lang/String;

    return-object v0
.end method

.method public getVerbosity()Lcom/adobe/mediacore/logging/Logger$Verbosity;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/logging/LogEntry;->verbosity:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    return-object v0
.end method
