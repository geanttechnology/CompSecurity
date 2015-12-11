.class Lcom/amazon/sdk/availability/FileStore$MeasureMentFilter;
.super Ljava/lang/Object;
.source "FileStore.java"

# interfaces
.implements Ljava/io/FilenameFilter;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/sdk/availability/FileStore;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "MeasureMentFilter"
.end annotation


# instance fields
.field private final timeStamp:J


# direct methods
.method public constructor <init>(J)V
    .locals 0
    .param p1, "timeStamp"    # J

    .prologue
    .line 537
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 538
    iput-wide p1, p0, Lcom/amazon/sdk/availability/FileStore$MeasureMentFilter;->timeStamp:J

    .line 539
    return-void
.end method


# virtual methods
.method public accept(Ljava/io/File;Ljava/lang/String;)Z
    .locals 6
    .param p1, "directory"    # Ljava/io/File;
    .param p2, "fileName"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 547
    if-eqz p2, :cond_0

    .line 548
    # getter for: Lcom/amazon/sdk/availability/FileStore;->PATTERN:Ljava/util/regex/Pattern;
    invoke-static {}, Lcom/amazon/sdk/availability/FileStore;->access$000()Ljava/util/regex/Pattern;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    .line 549
    .local v0, "matcher":Ljava/util/regex/Matcher;
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v2

    if-eqz v2, :cond_0

    new-instance v2, Ljava/io/File;

    invoke-direct {v2, p1, p2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/io/File;->lastModified()J

    move-result-wide v2

    iget-wide v4, p0, Lcom/amazon/sdk/availability/FileStore$MeasureMentFilter;->timeStamp:J

    cmp-long v2, v2, v4

    if-ltz v2, :cond_0

    const/4 v1, 0x1

    .line 551
    .end local v0    # "matcher":Ljava/util/regex/Matcher;
    :cond_0
    return v1
.end method
