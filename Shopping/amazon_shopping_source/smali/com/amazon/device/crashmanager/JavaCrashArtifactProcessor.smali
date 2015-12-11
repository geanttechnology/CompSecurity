.class Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;
.super Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;
.source "JavaCrashArtifactProcessor.java"


# static fields
.field public static final JAVA_CRASH_ARTIFACT_TAGS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public static final JAVA_STACK_TRACE_TAGS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final REGEX_STACK_TRACE_PATTERN:Ljava/util/regex/Pattern;

.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field private final mCrashDuplicateCount:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;

.field private final mJavaHeaderProcessor:Lcom/amazon/device/utils/DetUtil$HeaderProcessor;

.field private final mMetricsHeaderProcessor:Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 22
    new-instance v2, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v3, "JavaCrashArtifactProcessor"

    invoke-direct {v2, v3}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v2, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->log:Lcom/amazon/dp/logger/DPLogger;

    .line 35
    const-string/jumbo v2, "([a-zA-Z0-9_\\.]+(Exception|Error))|(at\\s.*\\(.*\\))"

    invoke-static {v2}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v2

    sput-object v2, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->REGEX_STACK_TRACE_PATTERN:Ljava/util/regex/Pattern;

    .line 41
    new-instance v0, Ljava/util/HashSet;

    const/16 v2, 0x8

    invoke-direct {v0, v2}, Ljava/util/HashSet;-><init>(I)V

    .line 42
    .local v0, "javaCrashArtifactTags":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    const-string/jumbo v2, "system_app_crash"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 43
    const-string/jumbo v2, "data_app_crash"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 44
    const-string/jumbo v2, "system_app_wtf"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 45
    const-string/jumbo v2, "system_server_crash"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 46
    const-string/jumbo v2, "system_server_watchdog"

    invoke-interface {v0, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 47
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v2

    sput-object v2, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->JAVA_CRASH_ARTIFACT_TAGS:Ljava/util/Set;

    .line 50
    new-instance v1, Ljava/util/HashSet;

    const/4 v2, 0x4

    invoke-direct {v1, v2}, Ljava/util/HashSet;-><init>(I)V

    .line 51
    .local v1, "javaStackTraceTags":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    const-string/jumbo v2, "system_app_crash"

    invoke-interface {v1, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 52
    const-string/jumbo v2, "data_app_crash"

    invoke-interface {v1, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 53
    const-string/jumbo v2, "system_server_crash"

    invoke-interface {v1, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 54
    const-string/jumbo v2, "system_app_wtf"

    invoke-interface {v1, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 55
    invoke-static {v1}, Ljava/util/Collections;->unmodifiableSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v2

    sput-object v2, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->JAVA_STACK_TRACE_TAGS:Ljava/util/Set;

    .line 56
    return-void
.end method

.method public constructor <init>(Lcom/amazon/device/utils/DetUtil;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/amazon/device/crashmanager/MetricsHeaderProcessorFactory;Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;)V
    .locals 4
    .param p1, "detUtil"    # Lcom/amazon/device/utils/DetUtil;
    .param p2, "deviceType"    # Ljava/lang/String;
    .param p3, "deviceSerialNumber"    # Ljava/lang/String;
    .param p5, "metricsHeaderProcessorFactory"    # Lcom/amazon/device/crashmanager/MetricsHeaderProcessorFactory;
    .param p6, "crashDuplicateCount"    # Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/device/utils/DetUtil;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/device/crashmanager/MetricsHeaderProcessorFactory;",
            "Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;",
            ")V"
        }
    .end annotation

    .prologue
    .line 65
    .local p4, "extraInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/amazon/device/crashmanager/AbstractDetArtifactProcessor;-><init>(Lcom/amazon/device/utils/DetUtil;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    .line 67
    if-nez p5, :cond_0

    .line 68
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "Metrics header processor factory must not be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 70
    :cond_0
    if-nez p6, :cond_1

    .line 71
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "Duplicate count must not be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 75
    :cond_1
    iget-object v1, p0, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->mHeaderWriter:Lcom/amazon/device/utils/DetUtil$HeaderWriter;

    invoke-virtual {p5, v1}, Lcom/amazon/device/crashmanager/MetricsHeaderProcessorFactory;->construct(Lcom/amazon/device/utils/DetUtil$HeaderProcessor;)Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->mMetricsHeaderProcessor:Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;

    .line 77
    new-instance v0, Ljava/util/HashMap;

    const/4 v1, 0x3

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    .line 80
    .local v0, "javaHeaderProcessors":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/device/utils/DetUtil$HeaderProcessor;>;"
    const-string/jumbo v1, "Process"

    iget-object v2, p0, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->mMetricsHeaderProcessor:Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 81
    const-string/jumbo v1, "hasForegroundActivities"

    iget-object v2, p0, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->mMetricsHeaderProcessor:Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 82
    const-string/jumbo v1, "Package"

    new-instance v2, Lcom/amazon/device/crashmanager/ExtractJavaVersionHeaderProcessor;

    iget-object v3, p0, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->mHeaderWriter:Lcom/amazon/device/utils/DetUtil$HeaderWriter;

    invoke-direct {v2, v3}, Lcom/amazon/device/crashmanager/ExtractJavaVersionHeaderProcessor;-><init>(Lcom/amazon/device/utils/DetUtil$HeaderProcessor;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 84
    new-instance v1, Lcom/amazon/device/utils/DetUtil$DefaultHeaderProcessor;

    iget-object v2, p0, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->mHeaderWriter:Lcom/amazon/device/utils/DetUtil$HeaderWriter;

    invoke-direct {v1, v0, v2}, Lcom/amazon/device/utils/DetUtil$DefaultHeaderProcessor;-><init>(Ljava/util/Map;Lcom/amazon/device/utils/DetUtil$HeaderProcessor;)V

    iput-object v1, p0, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->mJavaHeaderProcessor:Lcom/amazon/device/utils/DetUtil$HeaderProcessor;

    .line 88
    iput-object p6, p0, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->mCrashDuplicateCount:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;

    .line 89
    return-void
.end method


# virtual methods
.method protected addSpecificHeaders(Lcom/amazon/device/crashmanager/Artifact;Ljava/io/BufferedReader;Ljava/io/Writer;)V
    .locals 5
    .param p1, "artifact"    # Lcom/amazon/device/crashmanager/Artifact;
    .param p2, "reader"    # Ljava/io/BufferedReader;
    .param p3, "writer"    # Ljava/io/Writer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 196
    iget-object v2, p0, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->mMetricsHeaderProcessor:Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;

    invoke-virtual {p1}, Lcom/amazon/device/crashmanager/Artifact;->getTag()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;->setProcessTag(Ljava/lang/String;)V

    .line 199
    iget-object v2, p0, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->mJavaHeaderProcessor:Lcom/amazon/device/utils/DetUtil$HeaderProcessor;

    const-string/jumbo v3, "ContentType"

    const-string/jumbo v4, "JavaCrash"

    invoke-interface {v2, v3, v4, p3}, Lcom/amazon/device/utils/DetUtil$HeaderProcessor;->process(Ljava/lang/String;Ljava/lang/String;Ljava/io/Writer;)V

    .line 202
    iget-object v2, p0, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->mDetUtil:Lcom/amazon/device/utils/DetUtil;

    iget-object v3, p0, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->mJavaHeaderProcessor:Lcom/amazon/device/utils/DetUtil$HeaderProcessor;

    invoke-virtual {v2, p2, p3, v3}, Lcom/amazon/device/utils/DetUtil;->processHeaders(Ljava/io/BufferedReader;Ljava/io/Writer;Lcom/amazon/device/utils/DetUtil$HeaderProcessor;)V

    .line 207
    sget-object v2, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->JAVA_STACK_TRACE_TAGS:Ljava/util/Set;

    invoke-virtual {p1}, Lcom/amazon/device/crashmanager/Artifact;->getTag()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 208
    iget-object v2, p0, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->mJavaHeaderProcessor:Lcom/amazon/device/utils/DetUtil$HeaderProcessor;

    invoke-virtual {p0, p2, p3, v2}, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->extractJavaCrashInfoFromCrashBody(Ljava/io/BufferedReader;Ljava/io/Writer;Lcom/amazon/device/utils/DetUtil$HeaderProcessor;)Ljava/lang/String;

    move-result-object v0

    .line 211
    .local v0, "crashDescriptor":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 213
    iget-object v2, p0, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->mCrashDuplicateCount:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;

    invoke-virtual {v2, v0}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;->getCount(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    .line 216
    .local v1, "duplicateCrashCount":Ljava/lang/Integer;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v2

    const/4 v3, 0x1

    if-le v2, v3, :cond_0

    .line 220
    iget-object v2, p0, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->mJavaHeaderProcessor:Lcom/amazon/device/utils/DetUtil$HeaderProcessor;

    const-string/jumbo v3, "CrashDuplicateCount"

    invoke-virtual {v1}, Ljava/lang/Integer;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4, p3}, Lcom/amazon/device/utils/DetUtil$HeaderProcessor;->process(Ljava/lang/String;Ljava/lang/String;Ljava/io/Writer;)V

    .line 225
    .end local v1    # "duplicateCrashCount":Ljava/lang/Integer;
    :cond_0
    invoke-virtual {p1, v0}, Lcom/amazon/device/crashmanager/Artifact;->setCrashDescriptor(Ljava/lang/String;)V

    .line 227
    .end local v0    # "crashDescriptor":Ljava/lang/String;
    :cond_1
    return-void
.end method

.method public canProcessTag(Ljava/lang/String;)Z
    .locals 1
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 93
    sget-object v0, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->JAVA_CRASH_ARTIFACT_TAGS:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method protected extractJavaCrashInfoFromCrashBody(Ljava/io/BufferedReader;Ljava/io/Writer;Lcom/amazon/device/utils/DetUtil$HeaderProcessor;)Ljava/lang/String;
    .locals 11
    .param p1, "reader"    # Ljava/io/BufferedReader;
    .param p2, "writer"    # Ljava/io/Writer;
    .param p3, "headerProcessor"    # Lcom/amazon/device/utils/DetUtil$HeaderProcessor;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/16 v7, 0x6400

    const/4 v10, 0x0

    .line 144
    invoke-virtual {p1, v7}, Ljava/io/BufferedReader;->mark(I)V

    .line 146
    :try_start_0
    iget-object v7, p0, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->mBuffer:[C

    const/4 v8, 0x0

    const/16 v9, 0x6400

    invoke-virtual {p1, v7, v8, v9}, Ljava/io/BufferedReader;->read([CII)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 148
    invoke-virtual {p1}, Ljava/io/BufferedReader;->reset()V

    .line 153
    new-instance v6, Ljava/io/BufferedReader;

    new-instance v7, Ljava/io/CharArrayReader;

    iget-object v8, p0, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->mBuffer:[C

    invoke-direct {v7, v8}, Ljava/io/CharArrayReader;-><init>([C)V

    const/4 v8, 0x1

    invoke-direct {v6, v7, v8}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;I)V

    .line 156
    .local v6, "stackTraceReader":Ljava/io/BufferedReader;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 159
    .local v1, "extractedStackTrace":Ljava/lang/StringBuilder;
    iget-object v7, p0, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->mMetricsHeaderProcessor:Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;

    invoke-virtual {v7}, Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;->getProcessName()Ljava/lang/String;

    move-result-object v7

    if-eqz v7, :cond_0

    .line 160
    iget-object v7, p0, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->mMetricsHeaderProcessor:Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;

    invoke-virtual {v7}, Lcom/amazon/device/crashmanager/MetricsHeaderProcessor;->getProcessName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 163
    :cond_0
    const/4 v3, 0x0

    .line 166
    .local v3, "line":Ljava/lang/String;
    :goto_0
    invoke-virtual {v6}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_1

    .line 167
    sget-object v7, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->REGEX_STACK_TRACE_PATTERN:Ljava/util/regex/Pattern;

    invoke-virtual {v7, v3}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v5

    .line 170
    .local v5, "stackTraceMatcher":Ljava/util/regex/Matcher;
    invoke-virtual {v5}, Ljava/util/regex/Matcher;->find()Z

    move-result v7

    if-nez v7, :cond_2

    .line 178
    .end local v5    # "stackTraceMatcher":Ljava/util/regex/Matcher;
    :cond_1
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->length()I

    move-result v7

    if-gtz v7, :cond_3

    .line 179
    sget-object v7, Lcom/amazon/device/crashmanager/JavaCrashArtifactProcessor;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v8, "extractJavaCrashInfoFromCrashBody"

    const-string/jumbo v9, "No stack trace."

    new-array v10, v10, [Ljava/lang/Object;

    invoke-virtual {v7, v8, v9, v10}, Lcom/amazon/dp/logger/DPLogger;->warn(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 180
    const/4 v0, 0x0

    .line 189
    :goto_1
    return-object v0

    .line 148
    .end local v1    # "extractedStackTrace":Ljava/lang/StringBuilder;
    .end local v3    # "line":Ljava/lang/String;
    .end local v6    # "stackTraceReader":Ljava/io/BufferedReader;
    :catchall_0
    move-exception v7

    invoke-virtual {p1}, Ljava/io/BufferedReader;->reset()V

    throw v7

    .line 174
    .restart local v1    # "extractedStackTrace":Ljava/lang/StringBuilder;
    .restart local v3    # "line":Ljava/lang/String;
    .restart local v5    # "stackTraceMatcher":Ljava/util/regex/Matcher;
    .restart local v6    # "stackTraceReader":Ljava/io/BufferedReader;
    :cond_2
    invoke-virtual {v5}, Ljava/util/regex/Matcher;->group()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 184
    .end local v5    # "stackTraceMatcher":Ljava/util/regex/Matcher;
    :cond_3
    const-string/jumbo v7, "SHA1"

    invoke-static {v7}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v4

    .line 185
    .local v4, "messageDigest":Ljava/security/MessageDigest;
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/String;->getBytes()[B

    move-result-object v7

    invoke-virtual {v4, v7}, Ljava/security/MessageDigest;->digest([B)[B

    move-result-object v2

    .line 186
    .local v2, "hash":[B
    new-instance v7, Ljava/math/BigInteger;

    invoke-direct {v7, v2}, Ljava/math/BigInteger;-><init>([B)V

    invoke-virtual {v7}, Ljava/math/BigInteger;->abs()Ljava/math/BigInteger;

    move-result-object v7

    const/16 v8, 0x10

    invoke-virtual {v7, v8}, Ljava/math/BigInteger;->toString(I)Ljava/lang/String;

    move-result-object v0

    .line 188
    .local v0, "crashDescriptor":Ljava/lang/String;
    const-string/jumbo v7, "CrashDescriptor"

    invoke-interface {p3, v7, v0, p2}, Lcom/amazon/device/utils/DetUtil$HeaderProcessor;->process(Ljava/lang/String;Ljava/lang/String;Ljava/io/Writer;)V

    goto :goto_1
.end method
