.class final Lcom/newrelic/agent/android/AndroidAgentImpl$AppInfo;
.super Ljava/lang/Object;
.source "AndroidAgentImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/newrelic/agent/android/AndroidAgentImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "AppInfo"
.end annotation


# instance fields
.field private final appName:Ljava/lang/String;

.field private final appVersion:Ljava/lang/String;

.field private final packageManager:Landroid/content/pm/PackageManager;

.field private final packageName:Ljava/lang/String;


# direct methods
.method private constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/pm/PackageManager;)V
    .locals 0
    .param p1, "packageName"    # Ljava/lang/String;
    .param p2, "appName"    # Ljava/lang/String;
    .param p3, "appVersion"    # Ljava/lang/String;
    .param p4, "packageManager"    # Landroid/content/pm/PackageManager;

    .prologue
    .line 962
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 963
    iput-object p1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl$AppInfo;->packageName:Ljava/lang/String;

    .line 964
    iput-object p2, p0, Lcom/newrelic/agent/android/AndroidAgentImpl$AppInfo;->appName:Ljava/lang/String;

    .line 965
    iput-object p3, p0, Lcom/newrelic/agent/android/AndroidAgentImpl$AppInfo;->appVersion:Ljava/lang/String;

    .line 966
    iput-object p4, p0, Lcom/newrelic/agent/android/AndroidAgentImpl$AppInfo;->packageManager:Landroid/content/pm/PackageManager;

    .line 967
    return-void
.end method

.method public static fromContext(Landroid/content/Context;)Lcom/newrelic/agent/android/AndroidAgentImpl$AppInfo;
    .locals 9
    .param p0, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/newrelic/agent/android/AgentInitializationException;
        }
    .end annotation

    .prologue
    .line 902
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v6

    .line 903
    .local v6, "packageName":Ljava/lang/String;
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 910
    .local v5, "packageManager":Landroid/content/pm/PackageManager;
    const/4 v7, 0x0

    :try_start_0
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v4

    .line 911
    .local v4, "packageInfo":Landroid/content/pm/PackageInfo;
    if-eqz v4, :cond_0

    .line 912
    iget-object v2, v4, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 927
    .local v2, "appVersion":Ljava/lang/String;
    const/4 v7, 0x0

    :try_start_1
    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    .line 928
    .local v0, "appInfo":Landroid/content/pm/ApplicationInfo;
    if-eqz v0, :cond_1

    .line 929
    invoke-virtual {v5, v0}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/SecurityException; {:try_start_1 .. :try_end_1} :catch_2

    move-result-object v1

    .line 944
    .end local v0    # "appInfo":Landroid/content/pm/ApplicationInfo;
    .local v1, "appName":Ljava/lang/String;
    :goto_0
    new-instance v7, Lcom/newrelic/agent/android/AndroidAgentImpl$AppInfo;

    invoke-direct {v7, v6, v1, v2, v5}, Lcom/newrelic/agent/android/AndroidAgentImpl$AppInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/pm/PackageManager;)V

    return-object v7

    .line 915
    .end local v1    # "appName":Ljava/lang/String;
    .end local v2    # "appVersion":Ljava/lang/String;
    :cond_0
    :try_start_2
    new-instance v7, Lcom/newrelic/agent/android/AgentInitializationException;

    const-string v8, "No package info available for this app"

    invoke-direct {v7, v8}, Lcom/newrelic/agent/android/AgentInitializationException;-><init>(Ljava/lang/String;)V

    throw v7
    :try_end_2
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_2 .. :try_end_2} :catch_0

    .line 918
    .end local v4    # "packageInfo":Landroid/content/pm/PackageInfo;
    :catch_0
    move-exception v3

    .line 919
    .local v3, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    new-instance v7, Lcom/newrelic/agent/android/AgentInitializationException;

    const-string v8, "Could not determine package version"

    invoke-direct {v7, v8, v3}, Lcom/newrelic/agent/android/AgentInitializationException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v7

    .line 932
    .end local v3    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    .restart local v0    # "appInfo":Landroid/content/pm/ApplicationInfo;
    .restart local v2    # "appVersion":Ljava/lang/String;
    .restart local v4    # "packageInfo":Landroid/content/pm/PackageInfo;
    :cond_1
    move-object v1, v6

    .restart local v1    # "appName":Ljava/lang/String;
    goto :goto_0

    .line 935
    .end local v0    # "appInfo":Landroid/content/pm/ApplicationInfo;
    .end local v1    # "appName":Ljava/lang/String;
    :catch_1
    move-exception v3

    .line 936
    .restart local v3    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    # getter for: Lcom/newrelic/agent/android/AndroidAgentImpl;->log:Lcom/newrelic/agent/android/logging/AgentLog;
    invoke-static {}, Lcom/newrelic/agent/android/AndroidAgentImpl;->access$200()Lcom/newrelic/agent/android/logging/AgentLog;

    move-result-object v7

    invoke-virtual {v3}, Landroid/content/pm/PackageManager$NameNotFoundException;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v7, v8}, Lcom/newrelic/agent/android/logging/AgentLog;->warning(Ljava/lang/String;)V

    .line 937
    move-object v1, v6

    .line 942
    .restart local v1    # "appName":Ljava/lang/String;
    goto :goto_0

    .line 939
    .end local v1    # "appName":Ljava/lang/String;
    .end local v3    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :catch_2
    move-exception v3

    .line 940
    .local v3, "e":Ljava/lang/SecurityException;
    # getter for: Lcom/newrelic/agent/android/AndroidAgentImpl;->log:Lcom/newrelic/agent/android/logging/AgentLog;
    invoke-static {}, Lcom/newrelic/agent/android/AndroidAgentImpl;->access$200()Lcom/newrelic/agent/android/logging/AgentLog;

    move-result-object v7

    invoke-virtual {v3}, Ljava/lang/SecurityException;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v7, v8}, Lcom/newrelic/agent/android/logging/AgentLog;->warning(Ljava/lang/String;)V

    .line 941
    move-object v1, v6

    .restart local v1    # "appName":Ljava/lang/String;
    goto :goto_0
.end method


# virtual methods
.method public getAppName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 952
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl$AppInfo;->appName:Ljava/lang/String;

    return-object v0
.end method

.method public getAppVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 956
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl$AppInfo;->appVersion:Ljava/lang/String;

    return-object v0
.end method

.method public getPackageManager()Landroid/content/pm/PackageManager;
    .locals 1

    .prologue
    .line 960
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl$AppInfo;->packageManager:Landroid/content/pm/PackageManager;

    return-object v0
.end method

.method public getPackageName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 948
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl$AppInfo;->packageName:Ljava/lang/String;

    return-object v0
.end method
