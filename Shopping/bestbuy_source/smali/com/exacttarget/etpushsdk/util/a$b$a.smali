.class public Lcom/exacttarget/etpushsdk/util/a$b$a;
.super Ljava/security/SecureRandomSpi;
.source "SourceFile"


# static fields
.field private static final a:Ljava/io/File;

.field private static final b:Ljava/lang/Object;

.field private static c:Ljava/io/DataInputStream;

.field private static d:Ljava/io/OutputStream;


# instance fields
.field private e:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 906
    new-instance v0, Ljava/io/File;

    const-string v1, "/dev/urandom"

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/exacttarget/etpushsdk/util/a$b$a;->a:Ljava/io/File;

    .line 908
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/exacttarget/etpushsdk/util/a$b$a;->b:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 892
    invoke-direct {p0}, Ljava/security/SecureRandomSpi;-><init>()V

    return-void
.end method

.method private a()Ljava/io/DataInputStream;
    .locals 5

    .prologue
    .line 980
    sget-object v1, Lcom/exacttarget/etpushsdk/util/a$b$a;->b:Ljava/lang/Object;

    monitor-enter v1

    .line 981
    :try_start_0
    sget-object v0, Lcom/exacttarget/etpushsdk/util/a$b$a;->c:Ljava/io/DataInputStream;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v0, :cond_0

    .line 987
    :try_start_1
    new-instance v0, Ljava/io/DataInputStream;

    new-instance v2, Ljava/io/FileInputStream;

    sget-object v3, Lcom/exacttarget/etpushsdk/util/a$b$a;->a:Ljava/io/File;

    invoke-direct {v2, v3}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v0, v2}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V

    sput-object v0, Lcom/exacttarget/etpushsdk/util/a$b$a;->c:Ljava/io/DataInputStream;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 993
    :cond_0
    :try_start_2
    sget-object v0, Lcom/exacttarget/etpushsdk/util/a$b$a;->c:Ljava/io/DataInputStream;

    monitor-exit v1

    return-object v0

    .line 988
    :catch_0
    move-exception v0

    .line 989
    new-instance v2, Ljava/lang/SecurityException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Failed to open "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v4, Lcom/exacttarget/etpushsdk/util/a$b$a;->a:Ljava/io/File;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " for reading"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3, v0}, Ljava/lang/SecurityException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .line 994
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v0
.end method

.method private b()Ljava/io/OutputStream;
    .locals 3

    .prologue
    .line 998
    sget-object v1, Lcom/exacttarget/etpushsdk/util/a$b$a;->b:Ljava/lang/Object;

    monitor-enter v1

    .line 999
    :try_start_0
    sget-object v0, Lcom/exacttarget/etpushsdk/util/a$b$a;->d:Ljava/io/OutputStream;

    if-nez v0, :cond_0

    .line 1000
    new-instance v0, Ljava/io/FileOutputStream;

    sget-object v2, Lcom/exacttarget/etpushsdk/util/a$b$a;->a:Ljava/io/File;

    invoke-direct {v0, v2}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    sput-object v0, Lcom/exacttarget/etpushsdk/util/a$b$a;->d:Ljava/io/OutputStream;

    .line 1002
    :cond_0
    sget-object v0, Lcom/exacttarget/etpushsdk/util/a$b$a;->d:Ljava/io/OutputStream;

    monitor-exit v1

    return-object v0

    .line 1003
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method


# virtual methods
.method protected engineGenerateSeed(I)[B
    .locals 1

    .prologue
    .line 974
    new-array v0, p1, [B

    .line 975
    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/util/a$b$a;->engineNextBytes([B)V

    .line 976
    return-object v0
.end method

.method protected engineNextBytes([B)V
    .locals 4

    .prologue
    .line 954
    iget-boolean v0, p0, Lcom/exacttarget/etpushsdk/util/a$b$a;->e:Z

    if-nez v0, :cond_0

    .line 956
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/a$b;->b()[B

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/util/a$b$a;->engineSetSeed([B)V

    .line 961
    :cond_0
    :try_start_0
    sget-object v1, Lcom/exacttarget/etpushsdk/util/a$b$a;->b:Ljava/lang/Object;

    monitor-enter v1
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 962
    :try_start_1
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/util/a$b$a;->a()Ljava/io/DataInputStream;

    move-result-object v2

    .line 963
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 964
    :try_start_2
    monitor-enter v2
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    .line 965
    :try_start_3
    invoke-virtual {v2, p1}, Ljava/io/DataInputStream;->readFully([B)V

    .line 966
    monitor-exit v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 970
    return-void

    .line 963
    :catchall_0
    move-exception v0

    :try_start_4
    monitor-exit v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    :try_start_5
    throw v0
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_0

    .line 967
    :catch_0
    move-exception v0

    .line 968
    new-instance v1, Ljava/lang/SecurityException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Failed to read from "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Lcom/exacttarget/etpushsdk/util/a$b$a;->a:Ljava/io/File;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Ljava/lang/SecurityException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    .line 966
    :catchall_1
    move-exception v0

    :try_start_6
    monitor-exit v2
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    :try_start_7
    throw v0
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_0
.end method

.method protected engineSetSeed([B)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 937
    :try_start_0
    sget-object v1, Lcom/exacttarget/etpushsdk/util/a$b$a;->b:Ljava/lang/Object;

    monitor-enter v1
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 938
    :try_start_1
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/util/a$b$a;->b()Ljava/io/OutputStream;

    move-result-object v0

    .line 939
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 940
    :try_start_2
    invoke-virtual {v0, p1}, Ljava/io/OutputStream;->write([B)V

    .line 941
    invoke-virtual {v0}, Ljava/io/OutputStream;->flush()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 948
    iput-boolean v3, p0, Lcom/exacttarget/etpushsdk/util/a$b$a;->e:Z

    .line 950
    :goto_0
    return-void

    .line 939
    :catchall_0
    move-exception v0

    :try_start_3
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw v0
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 942
    :catch_0
    move-exception v0

    .line 945
    :try_start_5
    const-class v0, Lcom/exacttarget/etpushsdk/util/a$b;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Failed to mix seed into "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcom/exacttarget/etpushsdk/util/a$b$a;->a:Ljava/io/File;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 948
    iput-boolean v3, p0, Lcom/exacttarget/etpushsdk/util/a$b$a;->e:Z

    goto :goto_0

    :catchall_1
    move-exception v0

    iput-boolean v3, p0, Lcom/exacttarget/etpushsdk/util/a$b$a;->e:Z

    throw v0
.end method
