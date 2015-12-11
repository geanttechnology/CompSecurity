.class Lcom/amazon/device/crashmanager/ExtractJavaVersionHeaderProcessor;
.super Ljava/lang/Object;
.source "ExtractJavaVersionHeaderProcessor.java"

# interfaces
.implements Lcom/amazon/device/utils/DetUtil$HeaderProcessor;


# static fields
.field private static final JAVA_APP_VERSION_REGEX:Ljava/util/regex/Pattern;


# instance fields
.field private final mNextProcessor:Lcom/amazon/device/utils/DetUtil$HeaderProcessor;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const-string/jumbo v0, "^\\S+\\s+v(\\d+)\\s+\\((.+)\\)$"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/crashmanager/ExtractJavaVersionHeaderProcessor;->JAVA_APP_VERSION_REGEX:Ljava/util/regex/Pattern;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/device/utils/DetUtil$HeaderProcessor;)V
    .locals 0
    .param p1, "nextProcessor"    # Lcom/amazon/device/utils/DetUtil$HeaderProcessor;

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    iput-object p1, p0, Lcom/amazon/device/crashmanager/ExtractJavaVersionHeaderProcessor;->mNextProcessor:Lcom/amazon/device/utils/DetUtil$HeaderProcessor;

    .line 25
    return-void
.end method


# virtual methods
.method public process(Ljava/lang/String;Ljava/lang/String;Ljava/io/Writer;)V
    .locals 4
    .param p1, "header"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .param p3, "writer"    # Ljava/io/Writer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 31
    sget-object v1, Lcom/amazon/device/crashmanager/ExtractJavaVersionHeaderProcessor;->JAVA_APP_VERSION_REGEX:Ljava/util/regex/Pattern;

    invoke-virtual {v1, p2}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    .line 32
    .local v0, "appVersionMatcher":Ljava/util/regex/Matcher;
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 34
    iget-object v1, p0, Lcom/amazon/device/crashmanager/ExtractJavaVersionHeaderProcessor;->mNextProcessor:Lcom/amazon/device/utils/DetUtil$HeaderProcessor;

    const-string/jumbo v2, "Version"

    const/4 v3, 0x1

    invoke-virtual {v0, v3}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3, p3}, Lcom/amazon/device/utils/DetUtil$HeaderProcessor;->process(Ljava/lang/String;Ljava/lang/String;Ljava/io/Writer;)V

    .line 38
    :cond_0
    iget-object v1, p0, Lcom/amazon/device/crashmanager/ExtractJavaVersionHeaderProcessor;->mNextProcessor:Lcom/amazon/device/utils/DetUtil$HeaderProcessor;

    invoke-interface {v1, p1, p2, p3}, Lcom/amazon/device/utils/DetUtil$HeaderProcessor;->process(Ljava/lang/String;Ljava/lang/String;Ljava/io/Writer;)V

    .line 39
    return-void
.end method
